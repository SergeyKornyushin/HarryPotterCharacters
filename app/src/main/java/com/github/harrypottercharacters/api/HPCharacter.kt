package com.github.harrypottercharacters.api

data class HPCharacter(
    val actor: String,
    val alive: Boolean,
    val alternate_actors: List<Any>,
    val alternate_names: List<Any>,
    val ancestry: String,
    val dateOfBirth: String,
    val eyeColour: String,
    val gender: String,
    val hairColour: String,
    val hogwartsStaff: Boolean,
    val hogwartsStudent: Boolean,
    val house: String,
    val image: String,
    val name: String,
    val patronus: String,
    val species: String,
    val wand: Wand,
    val wizard: Boolean
)