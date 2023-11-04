import java.util.ArrayList;

public class formula {
    private ArrayList<Node> nodeList ;
    private ArrayList<NodeLinker> LinkerList ;
    void getData (CustomCanvas canvas){
         // todo: algo
         this.nodeList = new ArrayList<>(canvas.getNodes());
         this.LinkerList = new ArrayList<>(canvas.getLinks());
    }

     public String getFormula(CustomCanvas canvas){
        getData(canvas);
        NodeLinker used = null;
        StringBuilder str = new StringBuilder();
         for (Node node: nodeList) {
             str.append(node.symbol);
             for (NodeLinker link:LinkerList) {
                 used=null;
                 if(link.isIncluded(node)){
                     str.append(link.bondType);
                     str.append(link.otherNode(node).symbol);
                     used=link;
                 }
             }
             if(used!=null){
                 LinkerList.remove(used);
                 nodeList.remove(used.otherNode(node));
             }
         }

         return str.toString();
    }
}
