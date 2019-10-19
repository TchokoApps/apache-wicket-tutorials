package com.tchokoapps.apache.wicket.springbootexamplewicket.pages.util;

import com.googlecode.wickedcharts.highcharts.options.Function;

public final class FunctionUtils {

	public static Function pointNameAndPercent() {
		return new Function("return ''+ this.point.name +' ('+ this.percentage.toFixed(2) +'%)';");
	}

	public static Function xDecimalTypeColumn() {
		return new Function().setFunction(" return this.y.toFixed(2) ;");
	}

	public static Function xNameAndCurrencyTypeColumn() {
		return new Function().setFunction(" return ''+ this.x +': '+  ' R$ ' + this.y.toFixed(2);");
	}
}
