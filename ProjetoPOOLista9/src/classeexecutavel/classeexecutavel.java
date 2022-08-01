package classeexecutavel;

import javax.swing.JOptionPane;

import model.Agenda;
import model.Compromisso;

public class classeexecutavel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Agenda agenda = new Agenda();

		String usuario = JOptionPane.showInputDialog("Nome: ");
		agenda.setUsuario(usuario);

		String ano = JOptionPane.showInputDialog("Ano: ");
		agenda.setAno(Integer.parseInt(ano));

		int quantidade;
		String qtd = JOptionPane.showInputDialog("Quantidade de  compromissos: ");
		quantidade = Integer.parseInt(qtd);

		for (int i = 1; i <= quantidade; i++) {
			Compromisso compromissos = new Compromisso();

			String dia = JOptionPane.showInputDialog("Dia: ");
			compromissos.setDia(Integer.parseInt(dia));

			String mes = JOptionPane.showInputDialog("Mes: ");
			compromissos.setMes(Integer.parseInt(mes));

			String descricao = JOptionPane.showInputDialog("Descricao: ");
			compromissos.setDescricao(descricao);
			agenda.AdicionarCompromisso(compromissos);

		}
		System.out.println("------------------------------");
		System.out.println("Dados: ");

		System.out.println("Usuario: " + agenda.getUsuario());
		System.out.println("Ano: " + agenda.getAno());
		System.out.println("------------------------------");
		System.out.println("Listando os Compromissos:");
		for (Compromisso c : agenda.getCompromissos()) {
			System.out.println(c);

		}

		int resposta;
		resposta = JOptionPane.showConfirmDialog(null, "Remover Compromisso ? ");

		if (resposta == 0) {
			if (agenda.getSizeList()) {
				int dia = Integer.parseInt(JOptionPane.showInputDialog("Informe o dia: "));
				int mes = Integer.parseInt(JOptionPane.showInputDialog("Informe o mes: "));

				System.out.println(agenda.RemoverCompromisso(dia, mes));

			} else  {
				JOptionPane.showMessageDialog(null, "Lista Vazia");
				resposta = 1;
			}

		} else {
			resposta = 1;
		}
	}

}
