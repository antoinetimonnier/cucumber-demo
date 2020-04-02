package com.oxxeo.cucumberdemo.cucumber.step;

import java.util.Locale;
import java.util.Map;

import com.oxxeo.cucumberdemo.cucumber.datatable.CocktailDataTable;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;

/**
 * Classe de configuration pour les Data Table
 * @author an.timonnier
 *
 */
public class DataTableConfiguration implements TypeRegistryConfigurer {

	@Override
	public Locale locale() {
		return Locale.FRANCE;
	}

	@Override
	public void configureTypeRegistry(TypeRegistry typeRegistry) {
		typeRegistry.defineDataTableType(new DataTableType(CocktailDataTable.class, this::createCocktailDataTable));

	}

	/**
	 * Méthode de création d'une {@link CocktailDataTable}
	 * @param entries map contenant les entrées valeurs du tableau
	 * @return la datatable correspondante
	 */
	private CocktailDataTable createCocktailDataTable(Map<String, String> entries) {
		CocktailDataTable cocktailDatatable = new CocktailDataTable();
		cocktailDatatable.setNom(entries.get("nom"));
		cocktailDatatable.setPrix(entries.get("prix"));
		cocktailDatatable.setIngredients(entries.get("ingredients"));
		return cocktailDatatable;
	}

}
