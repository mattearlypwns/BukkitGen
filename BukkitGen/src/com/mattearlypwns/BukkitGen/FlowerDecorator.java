package com.mattearlypwns.BukkitGen;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class FlowerDecorator extends BlockPopulator {

	public void populate(World world, Random rand, Chunk chunk) {
		int x, y, z;

		for (x = 0; x < 16; ++x) {
			for (z = 0; z < 16; ++z) {

				if (rand.nextInt(1000) < 10) {
					for (y = 40; chunk.getBlock(x, y, z).getType() == Material.AIR; --y) {
					}

					chunk.getBlock(x, y + 1, z).setType(getFlower(rand));
				}
			}
		}
	}

	public Material getFlower(Random rand) {
		if (rand.nextInt(100) < 50)
			return Material.RED_ROSE;

		else
			return Material.YELLOW_FLOWER;
	}
}
