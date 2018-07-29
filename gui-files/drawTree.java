

public class drawTree {



    void drawTreeHtml(WireBSTNode head){


        if(head == null)
            return;

        System.out.println("<div>");
        System.out.println("<p>");
        head.printData();
        System.out.println("</p>");
        drawTreeHtml(head.getLeft());
        drawTreeHtml(head.getRight());
        System.out.println("</div>");



    }

}
