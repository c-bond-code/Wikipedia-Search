package com.example.application.views.wikipediasearch;

import java.io.IOException;
import java.util.ArrayList;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Wikipedia Search")
@Route(value = "WikipediaSearch", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class WikipediaSearchView extends HorizontalLayout {

    private TextField query;
    private Button queryButton;
    private ListBox<Results> listBox = new ListBox<>();

    public WikipediaSearchView() throws IOException {
        VerticalLayout mainLayout = new VerticalLayout();
        HorizontalLayout searchBar = new HorizontalLayout();

        // Call filepaths first
        if (WikipediaSearch.filePaths == null) {
            WikipediaSearch.filePaths = FileSearch.getPath();
        }

        // Main UI elements
        query = new TextField("Search Term");
        queryButton = new Button("Search");
        // When the user clicks search
        queryButton.addClickListener(e -> {
            // Clears any previous search results
            listBox.setItems();
            // Contains the list of top search results
            int[] index = null;
            try {
                index = WikipediaSearch.run(query.getValue());
            } catch (IOException event) {
                event.printStackTrace();
            }

            // Moves results into array list of objects so Vaadin knows how to handle it
            ArrayList<Results> results = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                Results r = new Results();
                r.name = WikipediaSearch.reducedNames.get(index[i]);
                r.path = WikipediaSearch.filePaths.get(WikipediaSearch.getIndex()[i]);
                results.add(r);
            }

            // Adds items to the display, then tells it how to format the display
            listBox.setItems(results);
            listBox.setRenderer(new ComponentRenderer<>(result -> {
                HorizontalLayout row = new HorizontalLayout();

                Span name = new Span(result.get_name());

                // Removes most of the system path from the display results
                String[] shorten = result.get_path().split("/");
                String simplePath = "https://claytonbond.dev/WikipediaSearch/wikiFiles";
                String displayPath = "WikipediaSearch/wikiFiles";

                for (int i = 7; i < shorten.length; i++) {
                    simplePath = simplePath + "/" + shorten[i];
                    displayPath = displayPath + "/" + shorten[i];
                }

                // Anchors turn the path into a clickable link
                Anchor link = new Anchor(simplePath, name);
                link.setTarget("_blank");
                Span clearText = new Span(displayPath);
                clearText.getStyle()
                        .set("color", "var(--lumo-secondary-text-color)")
                        .set("font-size", "var(--lumo-font-size-s)");

                // Styling
                VerticalLayout column = new VerticalLayout(link, clearText);
                column.setPadding(false);
                column.setSpacing(false);

                row.add(column);
                row.getStyle().set("line-height", "var(--lumo-line-height-m)");
                return row;
            }));
        });
        queryButton.addClickShortcut(Key.ENTER);

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, query, queryButton);

        searchBar.add(query, queryButton);
        mainLayout.add(searchBar, listBox);
        mainLayout.setWidth(65, Unit.PERCENTAGE);
        add(mainLayout);
    }

}
