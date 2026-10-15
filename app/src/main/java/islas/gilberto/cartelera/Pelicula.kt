package islas.gilberto.cartelera

data class Pelicula(
    val id: Int,
    val titulo: String,
    val anio: Int,
    val duracionMin: Int,
    val genero: String,
    val director: String,
    val sinopsis: String,
    val imagen: Int
)

val peliculas = listOf(
    Pelicula(
        id = 1,
        titulo = "Cómo entrenar a tu dragón",
        anio = 2010,
        duracionMin = 98,
        genero = "Animación, Aventura",
        director = "Chris Sanders y Dean DeBlois",
        sinopsis = "Hipo es un joven vikingo que vive en una isla donde los dragones son considerados enemigos. Todo cambia cuando conoce a Chimuelo, un dragón con el que forma una amistad que cambiará la relación entre vikingos y dragones.",
        imagen = R.drawable.httyd
    ),
    Pelicula(
        id = 2,
        titulo = "La Sirenita 2: Regreso al mar",
        anio = 2000,
        duracionMin = 75,
        genero = "Animación, Fantasía",
        director = "Jim Kammerud y Brian Smith",
        sinopsis = "Melody, la hija de Ariel y Eric, sueña con conocer el mundo submarino. Sin saber la verdad sobre su familia, se aventura al océano y termina involucrada en los planes de una malvada bruja del mar.",
        imagen = R.drawable.ls2
    ),
    Pelicula(
        id = 3,
        titulo = "Quiero comerme tu páncreas",
        anio = 2018,
        duracionMin = 108,
        genero = "Anime, Drama, Romance",
        director = "Shinichiro Ushijima",
        sinopsis = "Un estudiante solitario descubre el diario de Sakura, una compañera que padece una enfermedad terminal. A partir de ese momento desarrollan una amistad que cambia su manera de ver la vida.",
        imagen = R.drawable.qctp
    ),
    Pelicula(
        id = 4,
        titulo = "Ralph el demoledor",
        anio = 2012,
        duracionMin = 101,
        genero = "Animación, Comedia",
        director = "Rich Moore",
        sinopsis = "Ralph está cansado de ser el villano de su videojuego y decide demostrar que también puede ser un héroe. Durante su aventura conoce a Vanellope y descubre el verdadero significado de la amistad.",
        imagen = R.drawable.red
    ),
    Pelicula(
        id = 5,
        titulo = "Tierra de osos",
        anio = 2003,
        duracionMin = 85,
        genero = "Animación, Aventura",
        director = "Aaron Blaise y Robert Walker",
        sinopsis = "Kenai es un joven que se transforma mágicamente en oso después de buscar venganza. Durante su viaje conoce a Koda, un pequeño oso que le enseña el valor de la familia, el respeto y la empatía.",
        imagen = R.drawable.tdo
    ),
    Pelicula(
        id = 6,
        titulo = "A todos los chicos de los que me enamoré",
        anio = 2018,
        duracionMin = 99,
        genero = "Romance, Comedia",
        director = "Susan Johnson",
        sinopsis = "Lara Jean escribe cartas secretas a los chicos de los que se ha enamorado. Su vida cambia cuando las cartas son enviadas inesperadamente y debe enfrentarse a sus sentimientos.",
        imagen = R.drawable.tldlqme
    ),
    Pelicula(
        id = 7,
        titulo = "Toy Story",
        anio = 1995,
        duracionMin = 81,
        genero = "Animación, Aventura",
        director = "John Lasseter",
        sinopsis = "Woody es el juguete favorito de Andy, pero su lugar se ve amenazado cuando llega Buzz Lightyear. Ambos deberán aprender a trabajar juntos y descubrir el valor de la amistad.",
        imagen = R.drawable.ts
    ),
    Pelicula(
        id = 8,
        titulo = "Your Name",
        anio = 2016,
        duracionMin = 106,
        genero = "Anime, Romance, Fantasía",
        director = "Makoto Shinkai",
        sinopsis = "Mitsuha y Taki son dos adolescentes que comienzan a intercambiar cuerpos misteriosamente. Mientras intentan comprender lo que sucede, descubren una conexión que trasciende el tiempo y la distancia.",
        imagen = R.drawable.yn
    )
)
