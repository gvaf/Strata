/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.pricer.sensitivity;

import static com.opengamma.strata.basics.currency.Currency.CHF;
import static com.opengamma.strata.basics.currency.Currency.GBP;
import static com.opengamma.strata.basics.currency.Currency.USD;
import static com.opengamma.strata.basics.index.PriceIndices.CH_CPI;
import static com.opengamma.strata.basics.index.PriceIndices.GB_HICP;
import static com.opengamma.strata.collect.TestHelper.assertSerialization;
import static com.opengamma.strata.collect.TestHelper.coverBeanEquals;
import static com.opengamma.strata.collect.TestHelper.coverImmutableBean;
import static com.opengamma.strata.collect.TestHelper.date;
import static org.testng.Assert.assertEquals;

import java.time.YearMonth;

import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

/**
 * Test. 
 */
@Test
public class InflationRateSensitivityTest {

  private static final YearMonth REFERENCE_MONTH = YearMonth.of(2015, 6);

  public void test_of_withoutCurrency() {
    InflationRateSensitivity test = InflationRateSensitivity.of(GB_HICP, REFERENCE_MONTH, 1.0);
    assertEquals(test.getIndex(), GB_HICP);
    assertEquals(test.getCurrency(), GB_HICP.getCurrency());
    assertEquals(test.getReferenceMonth(), REFERENCE_MONTH);
    assertEquals(test.getSensitivity(), 1.0);
  }

  public void test_of_withCurrency() {
    InflationRateSensitivity test = InflationRateSensitivity.of(CH_CPI, REFERENCE_MONTH, 3.5);
    assertEquals(test.getIndex(), CH_CPI);
    assertEquals(test.getCurrency(), CH_CPI.getCurrency());
    assertEquals(test.getReferenceMonth(), REFERENCE_MONTH);
    assertEquals(test.getSensitivity(), 3.5);
  }

  public void test_withCurrency() {
    InflationRateSensitivity base = InflationRateSensitivity.of(CH_CPI, REFERENCE_MONTH, 3.5);
    assertEquals(base.withCurrency(CHF), base);
    InflationRateSensitivity expected = InflationRateSensitivity.of(CH_CPI, USD, REFERENCE_MONTH, 3.5);
    InflationRateSensitivity test = base.withCurrency(USD);
    assertEquals(test, expected);
  }

  public void test_withSensitivity() {
    InflationRateSensitivity base = InflationRateSensitivity.of(CH_CPI, REFERENCE_MONTH, 3.5);
    InflationRateSensitivity expected = InflationRateSensitivity.of(CH_CPI, REFERENCE_MONTH, 23.4);
    InflationRateSensitivity test = base.withSensitivity(23.4);
    assertEquals(test, expected);
  }

  public void test_mapSensitivity() {
    InflationRateSensitivity base = InflationRateSensitivity.of(CH_CPI, REFERENCE_MONTH, 5.0);
    InflationRateSensitivity expected = InflationRateSensitivity.of(CH_CPI, REFERENCE_MONTH, 1.0 / 5.0);
    InflationRateSensitivity test = base.mapSensitivity(s -> 1 / s);
    assertEquals(test, expected);
  }

  public void test_buildInto() {
    InflationRateSensitivity base = InflationRateSensitivity.of(GB_HICP, REFERENCE_MONTH, 3.5);
    MutablePointSensitivities combo = new MutablePointSensitivities();
    MutablePointSensitivities test = base.buildInto(combo);
    assertEquals(test, combo);
    assertEquals(test.getSensitivities(), ImmutableList.of(base));
  }

  public void test_compareExcludingSensitivity() {
    InflationRateSensitivity a1 = InflationRateSensitivity.of(GB_HICP, REFERENCE_MONTH, 32d);
    InflationRateSensitivity a2 = InflationRateSensitivity.of(GB_HICP, REFERENCE_MONTH, 32d);
    InflationRateSensitivity b = InflationRateSensitivity.of(CH_CPI, REFERENCE_MONTH, 32d);
    InflationRateSensitivity c = InflationRateSensitivity.of(GB_HICP, USD, REFERENCE_MONTH, 32d);
    InflationRateSensitivity d = InflationRateSensitivity.of(GB_HICP, YearMonth.of(2015, 10), 32d);
    ZeroRateSensitivity other = ZeroRateSensitivity.of(GBP, date(2015, 9, 27), 32d);
    assertEquals(a1.compareExcludingSensitivity(a2), 0);
    assertEquals(a1.compareExcludingSensitivity(b) > 0, true);
    assertEquals(b.compareExcludingSensitivity(a1) < 0, true);
    assertEquals(a1.compareExcludingSensitivity(c) < 0, true);
    assertEquals(c.compareExcludingSensitivity(a1) > 0, true);
    assertEquals(a1.compareExcludingSensitivity(d) < 0, true);
    assertEquals(d.compareExcludingSensitivity(a1) > 0, true);
    assertEquals(a1.compareExcludingSensitivity(other) < 0, true);
    assertEquals(other.compareExcludingSensitivity(a1) > 0, true);
  }

  public void test_multipliedBy() {
    InflationRateSensitivity base = InflationRateSensitivity.of(CH_CPI, REFERENCE_MONTH, 5.0);
    InflationRateSensitivity expected = InflationRateSensitivity.of(CH_CPI, REFERENCE_MONTH, 2.6 * 5.0);
    InflationRateSensitivity test = base.multipliedBy(2.6d);
    assertEquals(test, expected);
  }

  public void test_build() {
    InflationRateSensitivity base = InflationRateSensitivity.of(GB_HICP, REFERENCE_MONTH, 3.5);
    PointSensitivities test = base.build();
    assertEquals(test.getSensitivities(), ImmutableList.of(base));
  }

  public void coverage() {
    InflationRateSensitivity test1 = InflationRateSensitivity.of(GB_HICP, REFERENCE_MONTH, 1.0);
    coverImmutableBean(test1);
    InflationRateSensitivity test2 = InflationRateSensitivity.of(GB_HICP, GBP, REFERENCE_MONTH, 22.0);
    coverBeanEquals(test1, test2);
  }

  public void test_serialization() {
    InflationRateSensitivity test = InflationRateSensitivity.of(GB_HICP, REFERENCE_MONTH, 1.0);
    assertSerialization(test);
  }
}
