package br.com.locadora.diurno.dao;

import br.com.locadora.diurno.entidade.Veiculo;
import javax.ejb.*;

import java.io.ByteArrayOutputStream;
import java.util.List;
import javax.persistence.*;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Stateless
public class VeiculoDAO extends GenericDAO<Veiculo> {

	public VeiculoDAO(){
		super(Veiculo.class);
	}
	

	public ByteArrayOutputStream 
			pdfPorPreco(Double precoInicial, Double precoFinal) throws Exception {
		
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		Document document = new Document(PageSize.A4.rotate());
		
		PdfWriter.getInstance(document, output);
		
		document.open();
		
		List<Veiculo> veiculos = consultaPorPreco(precoInicial, precoFinal);
		
		Paragraph titulo = new Paragraph("Relatório de veículo por preço");
		titulo.setAlignment(Element.ALIGN_CENTER);
		
		document.add(titulo);
		
		PdfPTable table = new PdfPTable(4);
		table.setHeaderRows(1);
		table.setWidthPercentage(100);		
		table.setWidths(new int[]{10,20,35,35});
		
		String[] colunas = new String[]{"Cód.","Placa","Valor","Modelo"};
		
		
		for(String coluna : colunas){
			
			PdfPCell celula = new PdfPCell(new Phrase(coluna));
			celula.setBackgroundColor(BaseColor.LIGHT_GRAY);
			celula.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table.addCell(celula);
		}
		
		
		for(Veiculo veiculo : veiculos){
			
			PdfPCell cellId = new PdfPCell(new Phrase(veiculo.getIdVeiculo().toString()));
			
			PdfPCell cellPlaca 
					= new PdfPCell(new Phrase(veiculo.getPlaca()));
			
			PdfPCell cellValor 
				 	= new PdfPCell(new Phrase(veiculo.getValor().toString()));
			
			PdfPCell cellModelo 
					= new PdfPCell(new Phrase(veiculo.getModelo().getDescricao()));
			
			table.addCell(cellId);
			table.addCell(cellPlaca);
			table.addCell(cellValor);
			table.addCell(cellModelo);
		}
		
		
		document.add(table);
		
		document.close();
		
		return output;
	}
	
	
	public List<Veiculo> consultaPorPreco
					(Double precoInicial, Double precoFinal){
		
		TypedQuery<Veiculo> query 
				= super.em.createQuery("select v from Veiculo as v "
						+ "where v.valor between :v1 and :v2 ", Veiculo.class);
		
		//TypedQuery<Veiculo> query =
		//			em.createNamedQuery("veiculo.porPreco", Veiculo.class);
		
		query.setParameter("v1", precoInicial);
		query.setParameter("v2", precoFinal);
		
		
		
		return query.getResultList();
	}
}
