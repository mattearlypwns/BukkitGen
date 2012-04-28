package com.mattearlypwns.BukkitGen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

public class FlatLandsGenerator extends ChunkGenerator {

	public static final int deafultChunkHeight = 12;

	public byte[] generate(World world, Random random, int chunkx, int chunkz) {
		byte[] blocks = new byte[65536];
		int x, y, z;

		for (x = 0; x < 16; ++x) {
			for (z = 0; z < 16; ++z) {

				blocks[toInt(x, 0, z)] = (byte) Material.BEDROCK.getId();

				for (y = 1; y < deafultChunkHeight; ++y)
					blocks[toInt(x, y, z)] = (byte) Material.STONE.getId();

			}

		}

		return blocks;
	}

	private int toInt(int x, int y, int z) {
		return (x * 16 + z) * 256 + y;
	}

	ArrayList<BlockPopulator> populators;

	public List<BlockPopulator> getDefaultPopulators(World world) {
		populators = new ArrayList<BlockPopulator>();

		populators.add(new BiomeBlockDecorator());
		populators.add(new GrassDecorator());
		populators.add(new TreeDecorator());

		return populators;
	}

	public Location getFixedSpawnLocation(World world, Random random) {
		for (int i = 0; i < 100; ++i) {
			for (int j = 0; j < 100; ++j) {
				if (world.getChunkAt(i, j).getBlock(8, 8, 8).getBiome() == Biome.DESERT) {
					return world.getChunkAt(i, j).getBlock(8, 8, 8)
							.getLocation();
				} else
					continue;
			}
		}
		return new Location(world, 0, 0, 0);
	}
}
