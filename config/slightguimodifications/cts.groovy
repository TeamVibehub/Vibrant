// Here is the groovy file for screen elements
info("Hello From 'Slight' Gui Modifications cts script")

mainMenu {
    enabled = true

    splashText {
        enabled = true
        splashesEnabled = false
    }

    background {
        clearBackgrounds()
        backgroundStayLength = 10000
        backgroundFadeLength = 1000
        renderGradientShade = true
        image { texture = file("config/slightguimodifications/background.png") } // Add Frames to make a Gif background with gaussian blur
    }

    removeMinecraftLogo()
    removeEditionBadge()
    clearAllButtons()

    label {
        position {
            x = 2
            y {
                it - 20
            }
        }

        text = literal("Vibrant - Build 0.1.0 (Beta)")
    }

    button {
        position {
            x { it / 2 + 3 }
            y = 203
        }
        width = 100
        height = 20

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

        text = literal("Languages")
        onClicked = language()
    }
    button {
        position {
            x { it / 2 - 101 }
            y = 131
        }
        width = 204
        height = 20

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

        text = translatable("menu.multiplayer")
        onClicked = multiplayer()
    }
    button {
        position {
            x { it / 2 - 101 }
            y = 251
        }
        width = 204
        height = 20

        text = literal("Reload")
        onClicked = reloadCts()
    }
    
    button {
        position {
            x { it / 2 + 3 }
            y = 227
        }
        width = 100
        height = 20

        text = translatable("menu.quit")
        onClicked = exit()
    }
    button {
        position {
            x { it / 2 - 101 }
            y = 227
        }
        width = 100
        height = 20

        text = translatable("menu.options")
        onClicked = options()
    }
    button {
        position {
            x { it / 2 + 3 }
            y = 179
        }
        width = 100
        height = 20

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

        text = literal("Discord")
        onClicked = url("https://vibb.in/discord")
    }
}