package com.mattearlypwns.BukkitGen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

public class RollingHillsGenerator extends ChunkGenerator {

	public byte[] generate(World world, Random rand, int chunkx, int chunkz) {
		byte[] blocks = new byte[65536];
		int x, y, z;

		Random random = new Random(world.getSeed());
		SimplexOctaveGenerator octave = new SimplexOctaveGenerator(random, 8);

		octave.setScale(1 / 112.0);

		for (x = 0; x < 16; ++x) {
			for (z = 0; z < 16; ++z) {

				blocks[toInt(x, 0, z)] = (byte) Material.BEDROCK.getId();
				for (y = 1; y < 10; ++y) {
					blocks[toInt(x, y, z)] = (byte) Material.STONE.getId();
				}

				double noise = octave.noise(x + chunkx * 16, z + chunkz * 16,
						0.5, 0.1) * 10;

				for (y = 10; y < 20 + noise; ++y) {
					blocks[toInt(x, y, z)] = (byte) Material.DIRT.getId();
				}
				blocks[toInt(x, y, z)] = (byte) Material.GRASS.getId();
			}

		}

		return blocks;
	}

	private int toInt(int x, int y, int z) {
		return (x * 16 + z) * 256 + y;
	}

	public List<BlockPopulator> getDefaultPopulators(World world) {
		ArrayList<BlockPopulator> populators = new ArrayList<BlockPopulator>();

		populators.add(new FlowerDecorator());
		populators.add(new GrassDecorator());

		return populators;

	}

	public Location getFixedSpawnLocation(World world, Random random) {
		return world.getBlockAt(0, 0, 0).getLocation();

	}

}
