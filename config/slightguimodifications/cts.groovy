// Here is the groovy file for screen elements
info("Hello From 'Slight' Gui Modifications cts script")

mainMenu {
    enabled = true

    splashText {
        enabled = true
        splashesEnabled = false
    }

    removeMinecraftLogo()
    removeEditionBadge()
    clearAllButtons()
    clearAllLabels()

    label {
        position {
            x = 2
            y {
                it - 10
            }
        }
        color = 0x201f3d
        hoveredColor = 0x19d1a6
        shadow = true
        text = literal("Vibrant - Build 0.1.0 (Beta)")
    }

    label {
        position {
            x = 2
            y {
                it - 20
            }
        }
        color = 0x201f3d
        hoveredColor = 0x19d1a6
        shadow = true
        text = literal("Minecraft Fabric 1.16.3")
    }

    label {
        position {
            x { it - 2 }
            y {
                it - 10
            }
        }

        align = "right"
        color = 0x201f3d
        hoveredColor = 0x19d1a6
        shadow = true
        text = literal("Copyright Mojang AB. Do not Distribute!")
    }

   // Title Button

    button {
        position {
            x { it / 2 }
            y = 31
        }
        width = 300
        height = 80
        align = "center"
        texture = file("config/slightguimodifications/logo.png")
        onClicked = nothing()
    }

    //////////// Menu Buttons Start Here ////////////

    button {
        position {
            x { it / 2 - 101 }
            y = 131
        }
        width = 204
        height = 20

        texture = file("config/slightguimodifications/btn_large.png")
        hoveredTexture = file("config/slightguimodifications/btn_large-hover.png")
        text = translatable("menu.singleplayer")
        onClicked = singleplayer()
    }
    button {
        position {
            x { it / 2 - 101 }
            y = 155
        }
        width = 204
        height = 20

        texture = file("config/slightguimodifications/btn_large.png")
        hoveredTexture = file("config/slightguimodifications/btn_large-hover.png")
        text = translatable("menu.multiplayer")
        onClicked = multiplayer()
    }

    button {
        position {
            x { it / 2 + 3 }
            y = 179
        }
        width = 100
        height = 20

        texture = file("config/slightguimodifications/btn_med.png")
        hoveredTexture = file("config/slightguimodifications/btn_med-hover.png")
        text = literal("Our Website")
        onClicked = url("https://vibb.in")
    }
    button {
        position {
            x { it / 2 - 101 }
            y = 179
        }
        width = 100
        height = 20

        texture = file("config/slightguimodifications/btn_med.png")
        hoveredTexture = file("config/slightguimodifications/btn_med-hover.png")
        text = literal("Discord")
        onClicked = url("https://vibb.in/discord")
    }

    button {
        position {
            x { it / 2 + 3 }
            y = 203
        }
        width = 100
        height = 20

        texture = file("config/slightguimodifications/btn_med.png")
        hoveredTexture = file("config/slightguimodifications/btn_med-hover.png")
        text = modMenuText()
        onClicked = modMenu()
    }
    
    button {
        position {
            x { it / 2 - 101 }
            y = 203
        }
        width = 100
        height = 20

        texture = file("config/slightguimodifications/btn_med.png")
        hoveredTexture = file("config/slightguimodifications/btn_med-hover.png")
        text = translatable("menu.options")
        onClicked = options()
    }

    button {
        position {
            x { it / 2 - 101 }
            y = 227
        }
        width = 204
        height = 20

        texture = file("config/slightguimodifications/btn_large_exit.png")
        hoveredTexture = file("config/slightguimodifications/btn_large_exit-hover.png")
        text = translatable("\u00A74\u00A7lLeave Vibrant")
        onClicked = exit()
    }

    // Reload Button

    // button {
    //     position {
    //         x { it / 2 - 101 }
    //         y = 251
    //     }
    //     width = 204
    //     height = 20

    //     texture = file("config/slightguimodifications/btn_large_exit.png")
    //     hoveredTexture = file("config/slightguimodifications/btn_large_exit-hover.png")
    //     text = literal("\u00A76\u00A7lReload Custom Title Screen")
    //     onClicked = reloadCts()
    // }
}