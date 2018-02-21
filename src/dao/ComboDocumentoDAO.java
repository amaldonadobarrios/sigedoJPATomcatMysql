package dao;

import java.util.List;

import entity.ClasContenidoDoc;
import entity.ClasFuncionDoc;
import entity.PrioridadDoc;
import entity.TipoDoc;

public interface ComboDocumentoDAO {
public List<TipoDoc> ListaTipoDoc();
public List<ClasContenidoDoc> ListaClasContenidoDoc();
public List<ClasFuncionDoc> ListaClasFuncionDoc();
public List<PrioridadDoc> ListaPrioridadDoc();
}
