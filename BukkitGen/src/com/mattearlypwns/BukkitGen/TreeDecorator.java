package com.mattearlypwns.BukkitGen;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;

public class TreeDecorator extends BlockPopulator {

	TreeType tree;
	private int height = FlatLandsGenerator.deafultChunkHeight;
	int x, z;

	public void populate(World world, Random random, Chunk chunk) {

		for (x = 0; x < 3; ++x) {

			tree = randomTreeType(
					random,
					chunk.getBlock(random.nextInt(13) + x, height,
							random.nextInt(13) + x).getBiome());

			if (tree != null)
				world.generateTree(
						chunk.getBlock(random.nextInt(13) + x, height,
								random.nextInt(13) + x).getLocation(), tree);

			if (chunk.getBlock(random.nextInt(13) + x, height,
					random.nextInt(13) + x).getBiome() == Biome.JUNGLE
					|| chunk.getBlock(random.nextInt(13) + x, height,
							random.nextInt(16)).getBiome() == Biome.JUNGLE_HILLS) {

				for (int i = 0; i < 4; ++i) {
					world.generateTree(
							chunk.getBlock(random.nextInt(16), height,
									random.nextInt(16)).getLocation(),
							TreeType.JUNGLE_BUSH);

				}
			}
		}

	}

	/**
	 * Generates a random tree according to the biome type
	 * 
	 * @return TreeType
	 * @author mattearlypwns
	 */

	public TreeType randomTreeType(Random rand, Biome biome) {
		int random = rand.nextInt(100);

		if (biome == Biome.FOREST) {

			if (random < 50)
				return TreeType.TREE;

			else if (random < 90)
				return TreeType.BIRCH;

			else if (random < 100)
				return TreeType.BIG_TREE;

		} else if (biome == Biome.FOREST_HILLS) {

			if (random < 80)
				return TreeType.TREE;

			else
				return TreeType.BIG_TREE;

		} else if (biome == Biome.JUNGLE || biome == Biome.JUNGLE_HILLS) {

			if (random < 25)
				return TreeType.SMALL_JUNGLE;

			else if (random < 70)
				return TreeType.JUNGLE;

			else
				return TreeType.JUNGLE_BUSH;

		} else if (biome == Biome.MUSHROOM_ISLAND
				|| biome == Biome.MUSHROOM_SHORE) {

			if (random < 50)
				return TreeType.BROWN_MUSHROOM;

			else
				return TreeType.RED_MUSHROOM;

		} else if (biome == Biome.RAINFOREST || biome == Biome.SMALL_MOUNTAINS
				|| biome == Biome.TUNDRA)
			return TreeType.TREE;

		else if (biome == Biome.SEASONAL_FOREST)
			return TreeType.BIRCH;

		else if (biome == Biome.SWAMPLAND)
			return TreeType.SWAMP;

		else if (biome == Biome.TAIGA || biome == Biome.TAIGA_HILLS) {

			if (random < 75)
				return TreeType.REDWOOD;

			else
				return TreeType.TALL_REDWOOD;

		}
		return null;

	}
}
