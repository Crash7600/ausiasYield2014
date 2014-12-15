/* 
 * Copyright (C) 2014 rafa
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

var propuestaControl = function (strClase) {
    this.clase = strClase;
};
propuestaControl.prototype = new control('propuesta');
propuestaControl.prototype.getClassName = function () {
    return this.getClassName() + "Control";
};
propuestaControl.prototype.maskarma = function (place, id, oModel, oView) {
    var thisObject = this;
    $(place).empty();
    var oKarmaModel = oModel;
    oKarmaModel.loadAggregateViewOne(id);
    /*$(place).append(oView.getPanel("Borrado de " + this.clase, oView.getObjectTable(oDocumentoModel.getCachedPrettyFieldNames(), oDocumentoModel.getCachedOne(), oDocumentoModel.getCachedFieldNames())));*/
    $(place).append('<div id=\"result\">¿Darle karma positivo?</div>');
    $(place).append('<a class="btn btn-danger" id="btnvotarSi" href="#">Sí, votar positivo</a>');
    $('#btnvotarSi').unbind('click');
    $('#btnvotarSi').click(function (event) {
        resultado = oModel.duplicateOne(id);
        oView.doResultOperationNotifyToUser(place, resultado["status"], resultado["message"], resultado["message"], false);
        return false;
    });
};

propuestaControl.prototype.menoskarma = function (place, id, oModel, oView) {
    var thisObject = this;
    $(place).empty();
    var oKarmaModel = oModel;
    oKarmaModel.loadAggregateViewOne(id);
    /*$(place).append(oView.getPanel("Borrado de " + this.clase, oView.getObjectTable(oDocumentoModel.getCachedPrettyFieldNames(), oDocumentoModel.getCachedOne(), oDocumentoModel.getCachedFieldNames())));*/
    $(place).append('<div id=\"result\">¿Darle karma negativo?</div>');
    $(place).append('<a class="btn btn-danger" id="btnvotarNo" href="#">Sí, votar negativo</a>');
    $('#btnvotarNo').unbind('click');
    $('#btnvotarNo').click(function (event) {
        resultado = oModel.duplicateOne(id);
        oView.doResultOperationNotifyToUser(place, resultado["status"], resultado["message"], resultado["message"], false);
        return false;
    });
};
var oPropuestaControl = new propuestaControl('propuesta');
