package com.example.application.views.wikipediasearch;

import java.io.IOException;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("About Page")
@Route(value = "aboutpage", layout = MainLayout.class)
public class About extends VerticalLayout {

    public About() throws IOException {
        add(new H1("test"));
    }

}
