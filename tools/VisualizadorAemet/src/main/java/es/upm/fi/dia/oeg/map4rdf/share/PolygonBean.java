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
package es.upm.fi.dia.oeg.map4rdf.share;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alexander De Leon
 */
public class PolygonBean implements Polygon, Serializable {

	private ArrayList<Point> points;
	private String uri;

	PolygonBean() {
		// for serialization
	}

	public PolygonBean(String uri, Point... points) {
		this.points = new ArrayList<Point>(Arrays.asList(points));
		this.uri = uri;
	}

	public PolygonBean(String uri, List<Point> points) {
		this.points = new ArrayList<Point>(points);
		this.uri = uri;
	}

	@Override
	public String getUri() {
		return uri;
	}

	@Override
	public List<Point> getPoints() {
		if (points == null) {
			points = new ArrayList<Point>();
		}
		return points;
	}

	@Override
	public Type getType() {
		return Type.POLYGON;
	}

}
