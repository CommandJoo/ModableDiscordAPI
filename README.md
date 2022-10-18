# Modable Discord
Modable Discord is an API which allows you to configure a basic discord bot.
And have custom-made mods for it instead of coding everything into the bot at once

## How to set up
Create a directory where you put the "ModableDiscord-version.jar"
Once you have done that create a file called launch.sh or launch.bat and write 
```shell
java -jar "ModableDiscord-version.jar"
```
in it.

Launch the file an wait until it closes again
You will now have to configure your config.json file like this
````json
{
  "botToken": "MloPMTkxdVnNDgwqRx0MzM2MA.Gy-9SY._NudeeF0QjhUmLshW014A743XXXBktQj_GmSw",
  "guildID": "Guild ID to accept messages from",
  "onlineStatus": "ONLINE",
  "activity": {
    "name": "A Game",
    "type": "PLAYING"
  }
}
````

## How to create a Mod

Now you can launch your bot.
However it doesnt have any functionality what so ever
To create a new mod you have to setup a workspace in an ide of your choice and add the .jar file as a dependency.
After thats done you will make two files one for the Main-Class e.g. de.jo.TestMod and one for the mod info which is called mod.json

The Main-Class should look like this
```java
package de.jo.TestMod;

import de.jo.modablediscord.mod.impl.Mod;

public class TestMod extends Mod {
    
    public void onEnable() {
        //The Mod Starts Here
    }
    
    public void onDisable() {
        //The Mod Shuts down here
    }
    
}
```

The mod.json File should look like this
```json
{
  "main": "de.jo.TestMod",
  "name": "Test Mod",
  "author": "CommandJoo",
  "version": "1.0.0",
  "description": "This is a Test Mod"
}
```

Now simply put the mod into the "mods" folder of your bot, and you're done.