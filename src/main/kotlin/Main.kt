fun main() {

    println(
        "\nOla treinador pokemon, seja bem vindo ao centro pokemon!!\n" +
                "Por favor, nos diga seu nome: "
    )

    val nome = readLine().toString()

    println("\nEntao $nome, esta pronto para a batalha?")

    while (true) {
        val charizard = PokemonBase("Charizard", 50, 400)
        val blastoise = PokemonBase("Blastoise", 40, 500)
        val venusaur = PokemonBase("Venusaur", 35, 550)
        val mewTwo = PokemonBase("MewTwo", 40, 600)

        println(
            "\nEscolha seu pokemon para duelar contra o ${mewTwo.name} em uma simulacao:" +
                    "\n(1) - ${charizard.name}" +
                    "\n(2) - ${venusaur.name}" +
                    "\n(3) - ${blastoise.name}"
        )

        when (try {
            readLine()!!.toInt()
        } catch (e: NumberFormatException) {
            println("")
        }) {
            1 -> {
                println("Charizard, certo!? este e um pokemon bem forte!!")
                battle(charizard, mewTwo)
                fimDeJogo(mewTwo, charizard, nome)
            }

            2 -> {
                println("Venusaur, certo!? este e um pokemon bem resistente!!")
                battle(venusaur, mewTwo)
                fimDeJogo(mewTwo, venusaur, nome)
            }

            3 -> {
                println("Blastoise, certo!? este e um pokemon bem equilibrado!!")
                battle(blastoise, mewTwo)
                fimDeJogo(mewTwo, blastoise, nome)
            }
            else -> {
                println("Esta nao e uma opcao, escolha um dos pokemons!!")
                continue
            }
        }
        break
    }
}


fun battle(pokemon: PokemonBase, mewTwo: PokemonBase, pocao: Int = 50, originalHp: Int = pokemon.hp) {
    println("\nUm MewTwo se aproxima! Rapido, batalhe com ele!")

    while (mewTwo.hp > 0 && pokemon.hp > 0) {

        println("\n(1) Atacar\n(2) Usar pocao ")

        when (try {
            readLine()!!.toInt()
        } catch (e: NumberFormatException) {
            println("")
        }) {

            1 -> {
                println("${pokemon.name} atacou, causando ${pokemon.attack} de dano")
                mewTwo.hp = mewTwo.hp - pokemon.attack
            }

            2 -> {
                if (pokemon.hp < originalHp) {
                    println("Voce usou a pocao em seu pokemon, recuperando $pocao de vida")
                    pokemon.hp = pokemon.hp + pocao
                } else {
                    println("Vida ja esta cheia!!")
                }
            }

            else -> {
                println("Esta nao e uma opcao, escolha uma acao valida!!")
                continue
            }
        }

        println("\n${mewTwo.name} te ataca, Voce perde ${mewTwo.attack} de vida!!")
        pokemon.hp = pokemon.hp - mewTwo.attack
        println("\nA vida de ${mewTwo.name} e de ${mewTwo.hp}\nA vida do seu pokemon e de ${pokemon.hp}")
    }
}

fun fimDeJogo(mewTwo: PokemonBase, pokemon: PokemonBase, nome: String) {

    while (true) {
        if (mewTwo.hp <= 0) {
            println("\nVoce derrotou o ${mewTwo.name}, parabens $nome!!\nJogar novamente?")
            println("\n(1) - SIM!\n(2) - Nao..")
            when (try {
                readLine()!!.toInt()
            } catch (e: NumberFormatException) {
                println("")
            }) {
                1 -> main()
                2 -> {
                    println("FIM DE JOGO")
                    break
                }
                else -> println("Esta nao e uma das opcoes, escolha novamente! ")
            }
        } else if (pokemon.hp <= 0) {
            println("\nQue pena $nome, voce perdeu!!\nDeseja tentar novamente?")
            println("\n(1) - SIM!\n(2) - Nao..")
            when (try {
                readLine()!!.toInt()
            } catch (e: NumberFormatException) {
                println("")
            }) {
                1 -> main()
                2 -> {
                    println("FIM DE JOGO")
                    break
                }
                else -> println("Esta nao e uma das opcoes, escolha novamente! ")
            }
        }
    }
}



