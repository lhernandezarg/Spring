package com.prrin.model.records;

public record Pokemon(int id, String name, String type, int level_evolution) {

	public Pokemon(int id, String name) {
		this(id, name, "Normal", 1);
	}

	public Pokemon(int id, String name, String type) {
		this(id, name, type, 3);
	}

}
