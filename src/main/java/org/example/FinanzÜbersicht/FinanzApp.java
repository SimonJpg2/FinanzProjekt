package org.example.FinanzÜbersicht;

import org.example.FinanzÜbersicht.Backend.BackendController;
import org.example.FinanzÜbersicht.Backend.Security.SHA256;
import org.example.FinanzÜbersicht.Frontend.FrontendController;

/**
 * Class FinanzApp.
 *
 * <p>
 *     Application to get an overview about their finances.
 * </p>
 * @author Simon Balcke
 * @version 1.0
 * @since 08.05.2023
 */

public class FinanzApp {
    /**
     * Method main.
     *
     * <p>
     *     Initializes backend and frontend.
     * </p>
     * @param args unused
     */
    public static void main(String[] args) {
        String logo = """
                    ____________                                     \s
                   /   ______   \\                                   \s
                  /   /      \\___\\                                 \s
                 /   /                                                        \s
                /   /                                                         \s
                \\   \\                                                  ___________
                 \\   \\                                                |________   |
                  \\   \\_______      (__)                                       |  |
                   \\_______   \\                                                |  |
                           \\   \\     __                                        |  |   _______     _______
                            \\   \\   |  |   _____________     ____    _______   |  |  /       \\   /       \\
                             \\   \\  |  |  /  __ __ __   \\   /    \\  |/   _  \\  |  | /         \\ /         \\
                             /   /  |  | |  /  \\  /  \\  |  /      \\ |/  / \\  \\ |  | |   (__)  ||   (__)   |
                 ___        /   /   |  | |  |  |  |  |  | |  (__)  ||  |  |  | |  | |         / \\         |
                 \\  \\______/   /    |  | |  |  |  |  |  |  \\      / |  |  |  | |  | |   _____/   \\_____   |
                  \\___________/     |__| |__|  |__|  |__|   \\____/  |__|  |__| |  | |  |               |  |
                                                                               /  / |  |               |  |
                                                                        ______/  /  |  |         ______/  /     \s
                                                                       |________/   |__|        |________/\s
                                                                                               \s
                """;
        System.out.println("------------------------- Launching FinanzApp -------------------------");
        System.out.println(logo);
        System.out.println("\n\nThis application was created by Simon Balcke.\nSince 08.05.2023");
        System.out.println("-----------------------------------------------------------------------");
        var sha256 = new SHA256();
        new FrontendController(new BackendController(sha256), sha256);
    }
}
