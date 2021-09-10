package com.loginpage.viewmodel;


import IO.forpresentation.IPresentation;
import com.GenericRouter;
import com.userspage.view.UsersPage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;


import usecases.BusinessUseCaseImpl;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ViewModel<T> extends GenericRouter {
    IPresentation ip = new BusinessUseCaseImpl();

    @Override
    public void run() throws ExecutionException, InterruptedException {

        CompletableFuture D =  ip.getUsers();

        Scene scene2 = new UsersPage(new GridPane(), 640, 380);
        setroute(scene2);
        T F = (T)D.get();
        System.out.println(F);


    }

}

