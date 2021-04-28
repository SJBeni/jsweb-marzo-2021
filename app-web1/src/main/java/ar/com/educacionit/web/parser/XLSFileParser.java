package ar.com.educacionit.web.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ar.com.educacionit.domain.Producto;

public class XLSFileParser extends FileParserBase implements IFileParser {

	public XLSFileParser(String name) {
		super(name);
	}

	@Override
	public Collection<Producto> parse() throws IOException {
		
		File myFile = new File(super.name);
		
        FileInputStream excelFile = new FileInputStream(myFile);
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = datatypeSheet.iterator();
        
        Collection<Producto> productos = new ArrayList<>();
        
        boolean firstRow = true;
        //titulo|codigo|precio|tipo
        while (iterator.hasNext()) {

        	Row currentRow = iterator.next();
        	if(firstRow) {
        		firstRow = false;
        		continue;
        	}
        	
	        Iterator<Cell> cellIterator = currentRow.iterator();
	        
	        Producto producto = new Producto();
	        
	        while (cellIterator.hasNext()) {
	
	              Cell currentCell = cellIterator.next();
	              
	              switch(currentCell.getColumnIndex()) {
	              		case 0:
	              			producto.setTitulo(currentCell.getStringCellValue());
	              			break;
	              		case 1:
	              			producto.setCodigo(currentCell.getStringCellValue());
	              			break;
	              		case 2:
	              			producto.setPrecio((float)currentCell.getNumericCellValue());
	              			break;
	              		case 3:
	              			producto.setTipoProducto((long)currentCell.getNumericCellValue());
	              			break;
	              		default:
	              			break;
	              			
	              }
	        }
	        productos.add(producto);
        }
        workbook.close();
        return productos;
	}
}
