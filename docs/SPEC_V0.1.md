# TheWild v0.1 — Master Specification

## Identity
- Minecraft: 1.20.1
- Loader: Forge
- Theme: realistic hunting + fishing + survival
- Fauna: worldwide
- Vanilla mobs: coexist with TheWild fauna
- Models: realistic proportions/details adapted to Minecraft low-poly rendering
- Spawning: natural, biome-aware, species-specific

## Core gameplay loops
### Hunting
Explore -> discover sign -> identify species -> stalk -> shoot -> track blood/sign -> harvest -> eat/sell/trophy.

### Fishing
Choose rod/reel/line/hook/bait -> cast -> bite -> hook -> fight fish -> manage tension -> land fish -> weigh/measure -> eat/sell/record.

## Animal data model
Every species has:
- id, common_name, scientific_name
- diet
- preferred_biomes
- spawn_weight/density
- activity profile
- group size
- movement speed
- senses: vision/hearing/smell
- size and weight ranges
- sex distribution
- age range
- trophy data when applicable
- food/material drops
- hunting difficulty
- aggression/flee behaviour

Every spawned individual additionally gets randomized:
- sex
- age
- weight
- body scale
- health
- rarity/quality
- trophy score where applicable
- unique seed/id

## Tracking
Signs planned for v0.1:
- footprints
- blood
- carcass

Future signs:
- droppings
- hair/feathers
- feeding signs
- resting signs
- vocalizations

## Hunting damage
Initial implementation uses hit zones:
- head
- neck
- chest
- heart
- lungs
- abdomen
- legs

Damage is influenced by weapon, ammunition, distance, impact angle and penetration.

## Fishing data model
Each fish species has:
- common_name, scientific_name
- preferred biomes/water types
- depth band
- temperature band
- activity times
- weight/length ranges
- bait preferences
- lure preferences
- hook-size preference
- bite difficulty
- fight power
- rarity
- food value

Equipment is modular:
- rod
- reel
- line
- hook
- leader
- bait/lure

## Survival
Harvested animals/fish provide food and materials. Initial v0.1 focuses on raw meat/fish, cooking and basic drops; advanced processing can come later.

## Records and trophies
Player records track:
- largest fish by weight
- longest fish
- largest animal by weight
- highest trophy score
- species discovered
- total harvests

## UI
Initial screens:
- TheWild Encyclopedia
- Catch/Hunt record
- Equipment information
- Trophy/record view

## Technical architecture
Keep species and equipment data separate from gameplay logic. Prefer data-driven JSON resources for species, loot, spawning, equipment and balancing.

Suggested packages:
- com.rodrigo.thewild
- com.rodrigo.thewild.registry
- com.rodrigo.thewild.entity
- com.rodrigo.thewild.entity.ai
- com.rodrigo.thewild.tracking
- com.rodrigo.thewild.hunting
- com.rodrigo.thewild.fishing
- com.rodrigo.thewild.item
- com.rodrigo.thewild.client
- com.rodrigo.thewild.data
- com.rodrigo.thewild.world

## v0.1 scope
### Animals
1. Red deer
2. Wild boar
3. Red fox
4. Gray wolf
5. Brown bear
6. Moose
7. Roe deer
8. Elk
9. African lion
10. Plains zebra

### Fish
1. Brown trout
2. Rainbow trout
3. Northern pike
4. Largemouth bass
5. Common carp
6. Wels catfish
7. European perch
8. Zander
9. Atlantic salmon
10. Common barbel

### Hunting equipment
- .22 LR rifle
- .243 Winchester rifle
- .308 Winchester rifle
- 12-gauge shotgun
- Hunting bow
- Basic optic
- .22 LR ammunition
- .243 soft-point ammunition
- .308 soft-point ammunition
- 12-gauge buckshot/slugs

### Fishing equipment
- light spinning rod
- medium spinning rod
- feeder rod
- spinning reel
- feeder reel
- monofilament line
- braided line
- fluorocarbon leader
- hooks #2, #4, #6, #8, #10
- worm
- corn
- bread
- minnow
- spoon
- spinner
- soft plastic grub
- soft plastic craw
- crankbait
- jig

## v0.1 success criteria
1. At least four hunting animals can spawn naturally in appropriate biomes.
2. Player can identify and follow footprints.
3. Player can shoot, damage and harvest an animal.
4. Player can obtain edible meat/materials.
5. Player can equip fishing tackle and catch at least four fish.
6. Fish have variable weight/length.
7. Player can sell/store/record a catch.
8. Vanilla mobs remain functional.
9. All new content is data-driven where practical.
10. The project builds successfully through Gradle/GitHub Actions.
