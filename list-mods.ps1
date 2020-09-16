# Mod Listing Script by wrdg
# run $ .\list-mods.ps1 via CLI to List the mods

#Prints for MD
Clear-Content .\mods-markdown-format.txt -ErrorAction SilentlyContinue
Get-Content -Path "./config.json" | ConvertFrom-Json |`
    Select-Object -ExpandProperty mods -ErrorAction SilentlyContinue |`
    Select-Object -ExpandProperty projectID -ErrorAction SilentlyContinue |`
    ForEach-Object {
        $request = Invoke-RestMethod -Uri "https://curse.nikky.moe/api/addon/$_"
        Add-Content -Path .\mods-markdown-format.txt -Value "* [$($request.name)]($($request.websiteUrl))"
    }

# Prints out for CF HTML format
Clear-Content .\mods-curse-format.txt -ErrorAction SilentlyContinue
Get-Content -Path "./config.json" | ConvertFrom-Json |`
    Select-Object -ExpandProperty mods -ErrorAction SilentlyContinue |`
    Select-Object -ExpandProperty projectID -ErrorAction SilentlyContinue |`
    ForEach-Object {
        $request = Invoke-RestMethod -Uri "https://curse.nikky.moe/api/addon/$_"
        $message = '<li><a href="' + "$($request.websiteUrl)" + '" rel="nofollow">' + "$($request.name)" + '</a></li>'
        Add-Content -Path .\mods-curse-format.txt -Value "$message"
    }