/**
 * Copyright (c) 2011 Ontology Engineering Group, 
 * Departamento de Inteligencia Artificial,
 * Facultad de Inform�tica, Universidad 
 * Polit�cnica de Madrid, Spain
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package es.upm.fi.dia.oeg.map4rdf.server.command;

import java.util.List;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

import com.google.inject.Inject;

import es.upm.fi.dia.oeg.map4rdf.client.action.GetGeoResourceOverlays;
import es.upm.fi.dia.oeg.map4rdf.client.action.ListResult;
import es.upm.fi.dia.oeg.map4rdf.server.dao.Map4rdfDao;
import es.upm.fi.dia.oeg.map4rdf.share.GeoResourceOverlay;

/**
 * @author Alexander De Leon
 */
public class GetGeoResourceOverlaysHandler implements
		ActionHandler<GetGeoResourceOverlays, ListResult<GeoResourceOverlay>> {

	private final Map4rdfDao dao;

	@Inject
	public GetGeoResourceOverlaysHandler(Map4rdfDao dao) {
		this.dao = dao;
	}

	@Override
	public ListResult<GeoResourceOverlay> execute(GetGeoResourceOverlays action, ExecutionContext context)
			throws ActionException {
		try {
			List<GeoResourceOverlay> result = dao.getGeoResourceOverlays(action.getStatisticDefinition(), action
					.getBoundingBox(), action.getFacetConstraints());
			return new ListResult<GeoResourceOverlay>(result);
		} catch (Exception e) {

			throw new ActionException("Data access error", e);
		}
	}

	@Override
	public Class<GetGeoResourceOverlays> getActionType() {
		return GetGeoResourceOverlays.class;
	}

	@Override
	public void rollback(GetGeoResourceOverlays action, ListResult<GeoResourceOverlay> result, ExecutionContext context)
			throws ActionException {
		// Nothing to to this is a get

	}

}
