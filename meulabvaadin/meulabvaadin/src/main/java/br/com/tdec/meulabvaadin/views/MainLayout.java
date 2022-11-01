package br.com.tdec.meulabvaadin.views;


import br.com.tdec.meulabvaadin.components.appnav.AppNav;
import br.com.tdec.meulabvaadin.components.appnav.AppNavItem;
import br.com.tdec.meulabvaadin.views.about.AboutView;
import br.com.tdec.meulabvaadin.views.chat.ChatView;
import br.com.tdec.meulabvaadin.views.checkoutform.CheckoutFormView;
import br.com.tdec.meulabvaadin.views.collaborativemasterdetail.CollaborativeMasterDetailView;
import br.com.tdec.meulabvaadin.views.creditcardform.CreditCardFormView;
import br.com.tdec.meulabvaadin.views.dashboard.DashboardView;
import br.com.tdec.meulabvaadin.views.helloworld.HelloWorldView;
import br.com.tdec.meulabvaadin.views.helloworld2.HelloWorld2View;
import br.com.tdec.meulabvaadin.views.imagelist.ImageListView;
import br.com.tdec.meulabvaadin.views.list.ListView;
import br.com.tdec.meulabvaadin.views.map.MapView;
import br.com.tdec.meulabvaadin.views.masterdetail.MasterDetailView;
import br.com.tdec.meulabvaadin.views.masterdetail2.MasterDetail2View;
import br.com.tdec.meulabvaadin.views.personform.PersonFormView;
import br.com.tdec.meulabvaadin.views.richtexteditor.RichTextEditorView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H2 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.getElement().setAttribute("aria-label", "Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("MeuLabVaadin");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private AppNav createNavigation() {
        // AppNav is not yet an official component.
        // For documentation, visit https://github.com/vaadin/vcf-nav#readme
        AppNav nav = new AppNav();

        nav.addItem(new AppNavItem("Hello World", HelloWorldView.class, "la la-globe"));
        nav.addItem(new AppNavItem("About", AboutView.class, "la la-file"));
        nav.addItem(new AppNavItem("Dashboard", DashboardView.class, "la la-chart-area"));
        nav.addItem(new AppNavItem("List", ListView.class, "la la-th"));
        nav.addItem(new AppNavItem("Master-Detail", MasterDetailView.class, "la la-columns"));
        nav.addItem(new AppNavItem("Person Form", PersonFormView.class, "la la-user"));
        nav.addItem(
                new AppNavItem("Collaborative Master-Detail", CollaborativeMasterDetailView.class, "la la-columns"));
        nav.addItem(new AppNavItem("Credit Card Form", CreditCardFormView.class, "la la-credit-card"));
        nav.addItem(new AppNavItem("Map", MapView.class, "la la-map"));
        nav.addItem(new AppNavItem("Chat", ChatView.class, "la la-comments"));
        nav.addItem(new AppNavItem("Rich Text Editor", RichTextEditorView.class, "la la-edit"));
        nav.addItem(new AppNavItem("Image List", ImageListView.class, "la la-th-list"));
        nav.addItem(new AppNavItem("Checkout Form", CheckoutFormView.class, "la la-credit-card"));
        nav.addItem(new AppNavItem("Hello World2", HelloWorld2View.class, "la la-globe"));
        nav.addItem(new AppNavItem("Master-Detail2", MasterDetail2View.class, "la la-columns"));

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
