package application.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import application.models.Jogador;
import application.models.Missao;
import dao.JogadorDAO;
import dao.JogadorMissaoDAO;
import dao.MissaoDAO;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;

public class Validacao {
	
	
	public <T> void arrumaData(TableColumn<T, LocalDate> nome) {

		DateTimeFormatter Formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		nome.setCellFactory(cell -> {

			return new TableCell<T, LocalDate>() {

				@Override
				protected void updateItem(LocalDate item, boolean empty) {
					super.updateItem(item, empty);
					if (!empty && item != null) {

						setText(Formater.format(item));

					} else {
						setText("");
						setGraphic(null);
					}
				}
			};
		});

	}
//	public List<Missao> pegaIdMissao(){
//				
//		List<Missao> a= new ArrayList<Missao>();
//		List<Missao> b= new ArrayList<Missao>();
//		List<Missao> c= new ArrayList<Missao>();
//		Jogador j = new Jogador();
//		JogadorDAO jdao = new JogadorDAO();
//		JogadorMissaoDAO jmDAO = new JogadorMissaoDAO();
//		Missao m =new Missao();
//		MissaoDAO mdao = new MissaoDAO();
//
//		j = jdao.get(21);
//
//
//		j.setMissoes(jmDAO.listDados(j));
//		a = jmDAO.listMissaoNaoSelecionada(j);
//		c = jmDAO.listMissaoNaoSelecionada(j);
//		
//		Set<Missao> s = new HashSet<Missao>(a);
////		 for(Missao lista: a) {
////		
////					for(int i = 0; i+1 < j.getMissoes().size(); i++) {
////						 m = mdao.get(a.get(i).getIdMissao());
////		        if(m.getIdMissao()==lista.getIdMissao()) {
////		        	System.out.println(m);
////		        	System.out.println(lista);
////		        	a.remove(i);
////		   
////		        }
////		        	
////		      
////					}
////					
////		    }
////		
////	
////	
//		for(Missao pessoa : s)
//			{
//			for(int i =0; i<c.size();i++) {
//				if(c.get(i).getIdMissao()!=pessoa.getIdMissao()) {
//					System.out.println(pessoa);
//				}
//			}
//			   
//			}		
//		return a;		
//	}
//	
//	

}
