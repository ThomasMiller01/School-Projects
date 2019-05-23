/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thomas
 */
public class Control {      
    public static void main(String[] args){        
        BinaryTree<String> ll = new BinaryTree<>("Jacqueline Bouvier");
        BinaryTree<String> lr = new BinaryTree<>("Clancy Bouvier");
        BinaryTree<String> l = new BinaryTree<>("Marge Simpson", ll, lr);
        BinaryTree<String> rl = new BinaryTree<>("Mona Simpson");
        BinaryTree<String> rr = new BinaryTree<>("Abraham J. Simpson");
        BinaryTree<String> r = new BinaryTree<>("Homer Simpson", rl, rr);
        BinaryTree<String> ahnenbaum = new BinaryTree<>("Lisa Simpson", l, r);
//        preorderTraversierung(ahnenbaum);
//        inorderTraversierung(ahnenbaum);
//        postTraversierung(ahnenbaum);
        System.out.println(getNodeNmb(ahnenbaum));
    }
    
    static void preorderTraversierung(BinaryTree<String> tree){
        if(tree.getContent() != null){
            System.out.println(tree.getContent());   
        }        
        if(tree.getLeftTree() != null){
            preorderTraversierung(tree.getLeftTree());
        }
        if(tree.getRightTree() != null){
            preorderTraversierung(tree.getRightTree());
        }        
    }
    
    static void inorderTraversierung(BinaryTree<String> tree){             
        if(tree.getLeftTree() != null){
            inorderTraversierung(tree.getLeftTree());
        }
        if(tree.getContent() != null){
            System.out.println(tree.getContent());   
        }   
        if(tree.getRightTree() != null){
            inorderTraversierung(tree.getRightTree());
        }        
    }
    
    static void postTraversierung(BinaryTree<String> tree){             
        if(tree.getLeftTree() != null){
            postTraversierung(tree.getLeftTree());
        }        
        if(tree.getRightTree() != null){
            postTraversierung(tree.getRightTree());
        } 
        if(tree.getContent() != null){
            System.out.println(tree.getContent());   
        }   
    }
    
    static int getNodeNmb(BinaryTree<String> tree){                        
        int c1 = 0;
        int c2 = 0;
        if (!tree.getLeftTree().isEmpty()) {
            c1 = getNodeNmb(tree.getLeftTree());                
        }
        if (!tree.getRightTree().isEmpty()) {
            c2 = getNodeNmb(tree.getRightTree());                
        }           
        return c1 + c2 + 1;       
    }
}
