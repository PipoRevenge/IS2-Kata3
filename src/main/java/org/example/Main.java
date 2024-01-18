package org.example;

import org.example.analyzers.GameAnalyzer;
import org.example.analyzers.RecommendationAnalyzer;
import org.example.analyzers.UserAnalyzer;
import org.example.models.Game;
import org.example.models.Recommendation;
import org.example.models.User;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {



    }

    private static void showMainMenu() {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Iniciar Game Analyzer");
            System.out.println("2. Iniciar User Analyzer");
            System.out.println("3. Iniciar Recommendation Analyzer");
            System.out.println("4. Salir");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    runGameAnalyzer(scanner);
                    break;
                case 2:
                    runUserAnalyzer(scanner);
                    break;
                case 3:
                    runRecommendationAnalyzer(scanner);
                    break;
                case 4:
                    exitProgram(scanner);
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta de nuevo.");
                    break;
            }
        }
    }

    private static void runGameAnalyzer(Scanner scanner) {
        GameAnalyzer gameAnalyzer = GameAnalyzer.getInstance();
        System.out.println("Game Analyzer ha sido inicializado.");

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Obtener el juego con más reseñas positivas");
            System.out.println("2. Obtener el juego con más reseñas negativas");
            System.out.println("3. Agrupar juegos por calificación");
            System.out.println("4. Filtrar juegos");
            System.out.println("5. Volver al menú principal");

            int gameOption = scanner.nextInt();
            switch (gameOption) {
                case 1:
                    getGameWithMostPositiveReviews(gameAnalyzer);
                    break;
                case 2:
                    getGameWithMostNegativeReviews(gameAnalyzer);
                    break;
                case 3:
                    groupGamesByRating(gameAnalyzer);
                    break;
                case 4:
                    filterGames(gameAnalyzer);
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, intenta de nuevo.");
                    break;
            }
        }
    }


    private static void getGameWithMostPositiveReviews(GameAnalyzer gameAnalyzer) {
        Game gameWithMostPositiveReviews = gameAnalyzer.getGameWithMostPositiveReviews();
        System.out.println("El juego con más reseñas positivas es: " + gameWithMostPositiveReviews);
    }

    private static void getGameWithMostNegativeReviews(GameAnalyzer gameAnalyzer) {
        Game gameWithMostNegativeReviews = gameAnalyzer.getGameWithMostNegativeReviews();
        System.out.println("El juego con más reseñas negativas es: " + gameWithMostNegativeReviews);
    }

    private static void groupGamesByRating(GameAnalyzer gameAnalyzer) {
        Map<String, List<Game>> gamesGroupedByRating = gameAnalyzer.groupGamesByRating();
        System.out.println("Juegos agrupados por calificación: ");
        gamesGroupedByRating.forEach((rating, games) -> {
            System.out.println("Calificación: " + rating);
            games.stream().limit(10).forEach(game -> System.out.println(game));
        });
    }

    private static void filterGames(GameAnalyzer gameAnalyzer) {
        Predicate<Game> predicate = game -> game.getPositiveRatio() > 80;
        List<Game> filteredGames = gameAnalyzer.filterGames(predicate);
        System.out.println("Juegos filtrados por ratio mayor a 8: ");
        filteredGames.stream().limit(10).forEach(game -> System.out.println(game));
    }

    private static void runUserAnalyzer(Scanner scanner) {
        UserAnalyzer userAnalyzer = UserAnalyzer.getInstance();
        System.out.println("User Analyzer ha sido inicializado.");

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Obtener el usuario con más productos");
            System.out.println("2. Obtener el usuario con más reseñas");
            System.out.println("3. Filtrar usuarios");
            System.out.println("4. Volver al menú principal");

            int userOption = scanner.nextInt();
            switch (userOption) {
                case 1:
                    getUserWithMostProducts(userAnalyzer);
                    break;
                case 2:
                    getUserWithMostReviews(userAnalyzer);
                    break;
                case 3:
                    filterUsers(userAnalyzer);
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, intenta de nuevo.");
                    break;
            }
        }
    }

    private static void getUserWithMostProducts(UserAnalyzer userAnalyzer) {
        User userWithMostProducts = userAnalyzer.getUserWithMostProducts();
        System.out.println("El usuario con más productos es: " + userWithMostProducts);
    }

    private static void getUserWithMostReviews(UserAnalyzer userAnalyzer) {
        User userWithMostReviews = userAnalyzer.getUserWithMostReviews();
        System.out.println("El usuario con más reseñas es: " + userWithMostReviews);
    }

    private static void filterUsers(UserAnalyzer userAnalyzer) {
        Predicate<User> predicate = user -> user.getProducts() > 10;
        List<User> filteredUsers = userAnalyzer.filterUsers(predicate);
        System.out.println("Usuarios filtrados con más de 10 productos: ");
        filteredUsers.stream().limit(10).forEach(user -> System.out.println(user));
    }

    private static void runRecommendationAnalyzer(Scanner scanner) {
        RecommendationAnalyzer recommendationAnalyzer = RecommendationAnalyzer.getInstance();
        System.out.println("Recommendation Analyzer ha sido inicializado.");

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Obtener la recomendación más útil");
            System.out.println("2. Obtener la recomendación más divertida");
            System.out.println("3. Filtrar recomendaciones");
            System.out.println("4. Volver al menú principal");

            int recommendationOption = scanner.nextInt();
            switch (recommendationOption) {
                case 1:
                    getMostHelpfulRecommendation(recommendationAnalyzer);
                    break;
                case 2:
                    getMostFunnyRecommendation(recommendationAnalyzer);
                    break;
                case 3:
                    filterRecommendations(recommendationAnalyzer);
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, intenta de nuevo.");
                    break;
            }
        }
    }

    private static void getMostHelpfulRecommendation(RecommendationAnalyzer recommendationAnalyzer) {
        Recommendation mostHelpfulRecommendation = recommendationAnalyzer.getMostHelpfulRecommendation();
        System.out.println("La recomendación más útil es: " + mostHelpfulRecommendation);
    }

    private static void getMostFunnyRecommendation(RecommendationAnalyzer recommendationAnalyzer) {
        Recommendation mostFunnyRecommendation = recommendationAnalyzer.getMostFunnyRecommendation();
        System.out.println("La recomendación más divertida es: " + mostFunnyRecommendation);
    }

    private static void filterRecommendations(RecommendationAnalyzer recommendationAnalyzer) {
        Predicate<Recommendation> predicate = recommendation -> recommendation.getHelpful() > 10;
        List<Recommendation> filteredRecommendations = recommendationAnalyzer.filterRecommendations(predicate);
        System.out.println("Recomendaciones filtradas con más de 10 votos útiles: ");
        filteredRecommendations.stream().limit(10).forEach(recommendation -> System.out.println(recommendation));
    }

    private static void exitProgram(Scanner scanner) {
        System.out.println("Saliendo...");
        scanner.close();
        System.exit(0);
    }
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Iniciar Game Analyzer");
            System.out.println("2. Iniciar User Analyzer");
            System.out.println("3. Iniciar Recommendation Analyzer");
            System.out.println("4. Salir");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    GameAnalyzer gameAnalyzer = GameAnalyzer.getInstance();
                    System.out.println("Game Analyzer ha sido inicializado.");
                    while (true) {
                        System.out.println("Opciones:");
                        System.out.println("1. Obtener el juego con más reseñas positivas");
                        System.out.println("2. Obtener el juego con más reseñas negativas");
                        System.out.println("3. Agrupar juegos por calificación");
                        System.out.println("4. Filtrar juegos");
                        System.out.println("5. Volver al menú principal");

                        int gameOption = scanner.nextInt();
                        switch (gameOption) {
                            case 1:
                                Game gameWithMostPositiveReviews = gameAnalyzer.getGameWithMostPositiveReviews();
                                System.out.println("El juego con más reseñas positivas es: " + gameWithMostPositiveReviews);
                                break;
                            case 2:
                                Game gameWithMostNegativeReviews = gameAnalyzer.getGameWithMostNegativeReviews();
                                System.out.println("El juego con más reseñas negativas es: " + gameWithMostNegativeReviews);
                                break;
                            case 3:
                                Map<String, List<Game>> gamesGroupedByRating = gameAnalyzer.groupGamesByRating();
                                System.out.println("Juegos agrupados por calificación: ");
                                gamesGroupedByRating.forEach((rating, games) -> {
                                    System.out.println("Calificación: " + rating);
                                    games.stream().limit(10).forEach(game -> System.out.println(game));
                                });
                                break;
                            case 4:
                                // Aquí puedes definir tu propio predicado para filtrar los juegos
                                Predicate<Game> predicate = game -> game.getPositiveRatio() > 80;
                                List<Game> filteredGames = gameAnalyzer.filterGames(predicate);
                                System.out.println("Juegos filtrados por ratio mayor a 8: ");
                                filteredGames.stream().limit(10).forEach(game -> System.out.println(game));
                                break;
                            case 5:
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("Opción inválida. Por favor, intenta de nuevo.");
                                break;
                        }
                        if (gameOption == 5) {
                            break;
                        }
                    }
                    break;
                case 2:
                    UserAnalyzer userAnalyzer = UserAnalyzer.getInstance();
                    System.out.println("User Analyzer ha sido inicializado.");
                    while (true) {
                        System.out.println("Opciones:");
                        System.out.println("1. Obtener el usuario con más productos");
                        System.out.println("2. Obtener el usuario con más reseñas");
                        System.out.println("3. Filtrar usuarios");
                        System.out.println("4. Volver al menú principal");

                        int userOption = scanner.nextInt();
                        switch (userOption) {
                            case 1:
                                User userWithMostProducts = userAnalyzer.getUserWithMostProducts();
                                System.out.println("El usuario con más productos es: " + userWithMostProducts);
                                break;
                            case 2:
                                User userWithMostReviews = userAnalyzer.getUserWithMostReviews();
                                System.out.println("El usuario con más reseñas es: " + userWithMostReviews);
                                break;
                            case 3:
                                // Aquí puedes definir tu propio predicado para filtrar los usuarios
                                Predicate<User> predicate = user -> user.getProducts() > 10;
                                List<User> filteredUsers = userAnalyzer.filterUsers(predicate);
                                System.out.println("Usuarios filtrados con más de 10 productos: ");
                                filteredUsers.stream().limit(10).forEach(user -> System.out.println(user));
                                break;
                            case 4:
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("Opción inválida. Por favor, intenta de nuevo.");
                                break;
                        }
                        if (userOption == 4) {
                            break;
                        }
                    }
                    break;
                case 3:
                    RecommendationAnalyzer recommendationAnalyzer = RecommendationAnalyzer.getInstance();
                    System.out.println("Recommendation Analyzer ha sido inicializado.");
                    while (true) {
                        System.out.println("Opciones:");
                        System.out.println("1. Obtener la recomendación más útil");
                        System.out.println("2. Obtener la recomendación más divertida");
                        System.out.println("3. Filtrar recomendaciones");
                        System.out.println("4. Volver al menú principal");

                        int recommendationOption = scanner.nextInt();
                        switch (recommendationOption) {
                            case 1:
                                Recommendation mostHelpfulRecommendation = recommendationAnalyzer.getMostHelpfulRecommendation();
                                System.out.println("La recomendación más útil es: " + mostHelpfulRecommendation);
                                break;
                            case 2:
                                Recommendation mostFunnyRecommendation = recommendationAnalyzer.getMostFunnyRecommendation();
                                System.out.println("La recomendación más divertida es: " + mostFunnyRecommendation);
                                break;
                            case 3:
                                // Aquí puedes definir tu propio predicado para filtrar las recomendaciones
                                Predicate<Recommendation> predicate = recommendation -> recommendation.getHelpful() > 10;
                                List<Recommendation> filteredRecommendations = recommendationAnalyzer.filterRecommendations(predicate);
                                System.out.println("Recomendaciones filtradas con más de 10 votos útiles: ");
                                filteredRecommendations.stream().limit(10).forEach(recommendation -> System.out.println(recommendation));
                                break;
                            case 4:
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("Opción inválida. Por favor, intenta de nuevo.");
                                break;
                        }
                        if (recommendationOption == 4) {
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, intenta de nuevo.");
                    break;
            }
        }

    }
}
