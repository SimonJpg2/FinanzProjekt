package org.example.FinanzÜbersicht.Frontend;

import org.example.FinanzÜbersicht.Backend.BackendController;
import org.example.FinanzÜbersicht.Frontend.Frames.LoginFrame;
import org.example.FinanzÜbersicht.Frontend.Frames.RegisterFrame;

/**
 * Class FrontendController.
 * <p>
 *     Interacts between frontend and backend.
 * </p>
 * @author Simon Balcke
 * @version 1.0
 */
public class FrontendController {
    private final BackendController backendController;

    public FrontendController(BackendController backendController) {
        this.backendController = backendController;
        System.out.println("(~) Initializing JFrames.");

        // Frame initialisation
        RegisterFrame registerFrame = new RegisterFrame();
        LoginFrame loginFrame = new LoginFrame(registerFrame);
        System.out.println("(+) JFrames initialized successfully.");

        registerFrame.setLoginFrame(loginFrame);
        registerFrame.setVisible(true);
        loginFrame.setVisible(false);
    }
}
