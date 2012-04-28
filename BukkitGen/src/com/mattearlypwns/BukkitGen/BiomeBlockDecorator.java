package com.mattearlypwns.BukkitGen;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;

public class BiomeBlockDecorator extends BlockPopulator {

	private int x, y, z;

	public void populate(World world, Random rand, Chunk chunk) {

		for (x = 0; x < 16; ++x) {
			for (z = 0; z < 16; ++z) {
				for (y = 100; chunk.getBlock(x, y, z).getType() != Material.STONE; --y) {
				}

				chunk.getBlock(x, y, z).setType(
						getDefaultBlock(chunk.getBlock(x, y, z).getBiome()));

				chunk.getBlock(x, y - 1, z).setType(
						getUnderlyingBlock(chunk.getBlock(x, y, z).getBiome()));

			}
		}

	}

	public Material getDefaultBlock(Biome b) {

		if (b == Biome.BEACH || b == Biome.DESERT || b == Biome.DESERT_HILLS)
			return Material.SAND;

		else if (b == Biome.FROZEN_OCEAN || b == Biome.FROZEN_RIVER)
			return Material.ICE;

		else if (b == Biome.MUSHROOM_ISLAND || b == Biome.MUSHROOM_SHORE)
			return Material.MYCEL;

		else if (b == Biome.OCEAN || b == Biome.RIVER)
			return Material.WATER;

		else
			return Material.GRASS;
	}

	public Material getUnderlyingBlock(Biome b) {

		if (b == Biome.BEACH || b == Biome.DESERT || b == Biome.DESERT_HILLS)
			return Material.STONE;

		else if (b == Biome.FROZEN_OCEAN || b == Biome.FROZEN_RIVER)
			return Material.GRASS;

		else if (b == Biome.MUSHROOM_ISLAND || b == Biome.MUSHROOM_SHORE)
			return Material.DIRT;

		else if (b == Biome.OCEAN || b == Biome.RIVER)
			return Material.WATER;

		else
			return Material.DIRT;

	}
}
