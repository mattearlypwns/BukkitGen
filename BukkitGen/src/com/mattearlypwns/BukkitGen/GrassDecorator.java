package com.mattearlypwns.BukkitGen;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

public class GrassDecorator extends BlockPopulator {

	Biome biome;
	Block block, beneathBlock;
	int x, y, z;
	private int height = FlatLandsGenerator.deafultChunkHeight;
	boolean grass, deadGrass;

	public void populate(World world, Random rand, Chunk chunk) {
		grass = false;
		deadGrass = false;
		biome = chunk.getBlock(8, height, 8).getBiome();

		if (biome == Biome.FOREST || biome == Biome.FOREST_HILLS
				|| biome == Biome.PLAINS || biome == Biome.TUNDRA
				|| biome == Biome.TAIGA || biome == Biome.TAIGA_HILLS)
			grass = true;

		else if (biome == Biome.JUNGLE || biome == Biome.JUNGLE_HILLS)
			grass = true;
		else if (biome == Biome.DESERT || biome == Biome.DESERT_HILLS)
			deadGrass = true;

		else if (biome == Biome.SEASONAL_FOREST)
			grass = true;

		else if (biome == Biome.SWAMPLAND)
			grass = true;

		if (grass || deadGrass) {

			for (x = 0; x < 16; ++x) {
				for (z = 0; z < 16; ++z) {
					for (y = 20; chunk.getBlock(x, y, z).getType() == Material.AIR; --y) {
					}

					block = chunk.getBlock(x, y + 1, z);
					beneathBlock = chunk.getBlock(x, y, z);

					if (rand.nextInt(200) < 15
							&& beneathBlock.getType() == Material.GRASS
							&& grass)
						block.setTypeIdAndData(Material.LONG_GRASS.getId(),
								(byte) 1, false);

					else if (rand.nextInt(100) < 1
							&& beneathBlock.getType() == Material.SAND
							&& deadGrass)
						block.setTypeIdAndData(Material.LONG_GRASS.getId(),
								(byte) 0, false);

				}

			}
		}

	}

}
