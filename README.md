# Minecraft SkyWars

SkyWars is a popular gamemode within Minecraft where a bunch of players each spawn on their own floating island with loot chests. Goal is to eliminate all other players and be the last survivor.

Tested Spigot version: <b>1.20.1</b>

## Commands

| Command                      | Description                                            | Permission    |
| ---------------------------- | ------------------------------------------------------ | ------------- |
| /setspawn lobby              | Set lobby spawnpoint                                   | skywars.setup |
| /setspawn (mapname) (number) | Set map spawnpoints                                    | skywars.setup |
| /setspawn (mapname) (spec)   | Set map spectatorspawn                                 | skywars.setup |
| /build                       | Bypass build and inventory restrictions in lobby phase | skywars.setup |
| /start                       | Fast forward game countdown to 5 seconds               | skywars.start |

## Example Config

```yaml
config:
  mapname: house
  mapfolder: house
  min_players: 2
  max_players: 8
```

## Map reset

In order to use the mapreset feature place a backup of the map you're using in the <code>plugins/SkyWars/maps</code> folder. Once a game is over the plugin will overwrite the in the config.yml specified mapfolder with the version in <code>plugins/SkyWars/maps</code>.

## Chests

There are two types of chests. Normal (regular chest) and Epic (redstone/trapped chest).
