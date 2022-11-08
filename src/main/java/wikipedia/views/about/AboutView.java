package wikipedia.views.about;

import java.io.IOException;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import wikipedia.views.MainLayout;
import wikipedia.views.wikipediasearch.WikipediaSearch;

@PageTitle("About")
@Route(value = "about", layout = MainLayout.class)
public class AboutView extends VerticalLayout {

        public AboutView() throws IOException {
                VerticalLayout header = new VerticalLayout();

                Image img = new Image("images/logo.png", "Wiki Bronze");
                img.setWidth("200px");
                header.add(img);

                header.add(new H2("Wikipedia Search - Proof of Concept"));
                header.add(new Paragraph(
                                "Simple implementation of NLP techniques to find the most probable documents"));

                header.setJustifyContentMode(JustifyContentMode.CENTER);
                header.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
                header.getStyle().set("text-align", "center");

                add(header);

                VerticalLayout content = new VerticalLayout();

                content.add(new H2("About"));
                content.add(new Paragraph(
                                "The goal of this project is to take a collection of scrapped web pages, clean them up to a usable state, then use a couple NLP techniques to find what documents are most relevant to your search. Is it the most practical? No. Using prebuilt libraries like BeautifulSoup will yield better results with less effort. However, this has been a fun project to explore what’s going on behind the scenes. "));

                content.add(new H2("Process"));
                content.add(new Paragraph(
                                "We begin by recursively looking through the directory and creating a of files paths for every html file present. The dataset we’re working with is a web scrap of Wikipedia starting from the Quicksort Algorithm page, from there it branched out to related pages to download. Thus, most documents here are related to some sort of sorting algorithm. You can see the files we’re working with below. "));

                int numDocs = WikipediaSearch.filePaths.size();
                content.add(new Paragraph("Number of documents: " + numDocs));

                String[] docs = new String[numDocs];

                for (int i = 0; i < numDocs; i++) {
                        String[] split = WikipediaSearch.filePaths.get(i).split("/");
                        String name = split[split.length - 1].replaceAll("_", " ");
                        docs[i] = name.substring(0, name.length() - 5);
                }

                ListBox<String> listBox = new ListBox<>();
                listBox.setItems(docs);
                listBox.setHeight("200px");
                content.add(listBox);

                listBox.addValueChangeListener(event -> {
                        Page page = UI.getCurrent().getPage();
                        page.executeJs("window.open($0)",
                                        "https://claytonbond.dev/WikipediaSearch/wikiFiles/"
                                                        + event.getValue().replaceAll(" ", "_")
                                                        + ".html");
                });

                content.add(new Paragraph(
                                "Once we have all the file names, we can order the list from top to bottom according to probability based on how closely the title of the file relates to the query. For example, if we searched for “Banana Float” a document with both “Banana” and “Float” in its title would be ranked higher than something with only 1 keyword like “Banana”."));
                content.add(new Paragraph(
                                "Once we have this list of our most probable, we can start getting the documents cleaned up into something we can work with."));

                String a = "Run each document through the Tokenizer to remove as many html tags as possible.";
                String b = "Run each document through a spell checker. This will further remove anything that’s not a clear English word and weed out some of the remaining formatting.";
                String c = "Finally, run TF-IDF to identify the more important keywords and get rid of less valuable words like “and” “or” “the” etc.";

                MultiSelectListBox<String> bullets = new MultiSelectListBox<>();
                bullets.setItems(a, b, c);
                bullets.select(a, b, c);
                content.add(bullets);

                content.add(new Paragraph(
                                "Finally, we have a data that’s clean enough to work with. We can now run Naïve Bayes to rank the documents based on what document matches our query best!"));

                content.add(new Paragraph(""));
                content.setWidth("50%");
                add(content);

                setSpacing(false);
                setJustifyContentMode(JustifyContentMode.CENTER);
                setDefaultHorizontalComponentAlignment(Alignment.CENTER);
                // getStyle().set("text-align", "center");
        }

}
