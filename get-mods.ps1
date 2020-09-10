# Mod Fetching Script by wrdg
# run $ ./get-mods.ps1 via CLI to download the mods

$maxConcurrentJobs = 20
$Runspace = [RunspaceFactory]::CreateRunspacePool(1, $maxConcurrentJobs)
$Runspace.Open()

$TopLevel = Invoke-Expression "git rev-parse --show-toplevel"

[string[]]$contentMods = Get-Content -Path "$TopLevel/config.json" | ConvertFrom-Json |`
    Select-Object -ExpandProperty mods |`
    Select-Object -ExpandProperty downloadUrl

[string[]]$currentMods = Get-ChildItem -Path "$TopLevel/mods/" | Where-Object {
    !($_.PSIsContainer) -and $_.Extension -eq ".jar"
}

foreach ($mod in $contentMods) {
    $short = ($mod -split '/')[-1]

    $ps = [PowerShell]::Create()
    $ps.RunspacePool = $Runspace

    if ($currentMods -notcontains $short) {
        Write-Host "Downloading: $short"

        [void]$ps.AddCommand("Invoke-WebRequest").AddParameter("Uri", $mod).AddParameter("OutFile", "$TopLevel/mods/$short")
        [void]$ps.BeginInvoke()
    }
}