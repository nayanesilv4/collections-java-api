package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    //atributo
    private List<Item> itemList;

    public CarrinhoDeCompras() {

        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome,int quantidade, double preco){

        Item item = new Item(nome, quantidade, preco);
        this.itemList.add(item);
    }

    public void removerItem(String nome){
        List<Item> itensParaRemover = new ArrayList<>();

        if(!itemList.isEmpty()){
            for(Item i : itemList){
                if(i.getNome().equalsIgnoreCase(nome)){
                    itensParaRemover.add(i);
                }
            }
            itemList.removeAll(itensParaRemover);
        } else {
            System.out.println("O carrinho de compras está vazio");
        }
    }

    public double calcularValorTotal(){
        double valorTotal = 0d;
        if(!itemList.isEmpty()){
            for(Item item : itemList){
                double valorItem = item.getPreco() * item.getQuantidade();
                valorTotal += valorItem;
            }
            return valorTotal;
        } else{
            throw new RuntimeException("O carrinho de compras está vazio");
        }
    }

    public void exibirItens(){
        if(!itemList.isEmpty()){
            System.out.println(this.itemList);
        }else{
            System.out.println("O carrinho de compras está vazio");
        }
    }
    @Override
    public String toString() {
        return "CarrinhoDeCompras{" +
                "itens=" + itemList +
                '}';
    }

    public static void main(String[] args) {
        // criando uma instância do carrinho de compras
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        // Adicionar itens ao carrinho
        carrinhoDeCompras.adicionarItem("Lápis", 3, 2d);
        carrinhoDeCompras.adicionarItem("Lápis", 3, 2d);
        carrinhoDeCompras.adicionarItem("Caderno", 1, 35d);
        carrinhoDeCompras.adicionarItem("Borracha", 2, 2d);

        // Exibindo os itens ao carrinho
        carrinhoDeCompras.exibirItens();

        //Removendo um item do carrinho
        carrinhoDeCompras.removerItem("Lápis");

        // Exibindo os itens atualizados
        carrinhoDeCompras.exibirItens();

        //Calculando e exibindo o valor dos itens
        System.out.println("O valor total da compra é: " + carrinhoDeCompras.calcularValorTotal());
    }

}
