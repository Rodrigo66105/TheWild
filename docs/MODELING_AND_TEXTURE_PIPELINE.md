# TheWild — 3D models and textures

## Recommended free workflow

1. Generate a reference/model with an AI 3D tool such as Tripo or Meshy when the free tier is sufficient.
2. Export OBJ/GLB.
3. Open/import it in Blockbench.
4. Rebuild or simplify the geometry into a Minecraft-friendly low-poly/cuboid model where appropriate.
5. Create/paint the final texture in Blockbench.
6. Export the format needed by the Forge entity/item renderer.
7. Store the final assets under `src/main/resources/assets/thewild/`.

## Important
AI mesh generators do not directly produce native Minecraft Java entity models. Meshy explicitly notes that its generated meshes are not directly usable as vanilla Java cuboid models; Blockbench is the bridge for Minecraft-specific modeling. For TheWild, we should treat AI output primarily as a reference/base mesh, then optimize the final asset for Minecraft. 

## Style target
- Realistic proportions
- Recognizable anatomy
- Low/medium polygon budget
- Minecraft-compatible silhouette
- No neon/overly stylized colours
- Natural materials and believable markings
- Consistent scale between species

## Texture target
For most animals, start around 64x64 or 128x128 depending on model complexity. Use pixel-aware painting rather than photographic textures so the result fits Minecraft.

## AI prompt template
"Realistic [species], full body, neutral standing pose, accurate anatomy, natural proportions, game-ready low-poly reference, clean silhouette, isolated on plain background, no accessories, no text."

For a Minecraft-oriented reference:
"Realistic low-poly [species] designed for a Minecraft Forge mod, block-friendly proportions, simplified but anatomically recognizable, clean silhouette, natural fur/skin colours, neutral standing pose, isolated background."

## Texture prompt template
"Seamless game texture for a realistic low-poly [species], natural [fur/skin/scale] colours, subtle species-accurate markings, clean readable details at low resolution, no text, no background, no lighting baked into the texture."

## Licence note
Before distributing AI-generated assets, verify the current free-tier export and commercial-use terms of the generator used. TheWild should keep a small `ASSET_SOURCES.md` file recording source/tool/license for every externally generated asset.
