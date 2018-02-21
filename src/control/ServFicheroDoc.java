package control;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import entity.FicheroDoc;
import logica.LogicaFichero;
import util.HtmlUtil;

/**
 * Servlet implementation class ServFicheroDoc
 */
@WebServlet("/ServFicheroDoc")
public class ServFicheroDoc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServFicheroDoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FicheroDoc Fichero = null;
		String id = null;
		System.out.println(this.getClass().getName());
		if (ServletFileUpload.isMultipartContent(request)) {
			System.out.println(this.getClass().getName() + "ES MULTIPART");
			byte[] bFile;
			List<FileItem> multiparts = null;

			try {
				multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

			} catch (FileUploadException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (multiparts != null) {
				Fichero = new FicheroDoc();

				for (FileItem item : multiparts) {

					System.out.println(this.getClass().getName() + multiparts.size());
					if (!item.isFormField()) {
						try {
							InputStream fileContent = item.getInputStream();
							bFile = IOUtils.toByteArray(fileContent);
							String type = item.getContentType();
							Fichero.setBlob(bFile);
							Fichero.setEstado(1);
							Fichero.setNombre(item.getName());
							String str = String.valueOf(item.getSize());
							Fichero.setSize(str);
							Fichero.setTipo(type);
						} catch (Exception e) {
							System.out.println(this.getClass().getName() + "ERROR : " + e);
							Fichero = null;
						}
					}

				}
			}
		}
		if (Fichero != null) {
			id = String.valueOf(LogicaFichero.getInstance().GrabarFichero(Fichero));
		}

		HtmlUtil.getInstance().escrituraHTML(response, id);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
