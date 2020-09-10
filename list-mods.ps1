# Mod Listing Script by wrdg
# run $ ./list-mods.ps1 via CLI to List the mods

Clear-Content .\mods.txt -ErrorAction SilentlyContinue
Get-Content -Path "./config.json" | ConvertFrom-Json |`
    Select-Object -ExpandProperty mods -ErrorAction SilentlyContinue |`
    Select-Object -ExpandProperty projectID -ErrorAction SilentlyContinue |`
    ForEach-Object {
        $request = Invoke-RestMethod -Uri "https://curse.nikky.moe/api/addon/$_"
        Add-Content -Path .\mods.txt -Value "[$($request.name)]($($request.websiteUrl))"
    }