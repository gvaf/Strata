/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.strata.market.id;

import com.opengamma.strata.basics.market.MarketDataId;
import com.opengamma.strata.finance.credit.SingleNameReferenceInformation;
import com.opengamma.strata.market.curve.IsdaCreditCurveParRates;
import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Market data ID for a set of par rates to be used in the ISDA credit model's credit curve
 * calibration for a single name.
 */
@BeanDefinition(builderScope = "private")
public final class IsdaSingleNameCreditCurveParRatesId implements MarketDataId<IsdaCreditCurveParRates>, ImmutableBean {

  @PropertyDefinition(validate = "notNull")
  private final SingleNameReferenceInformation referenceInformation;

  @Override
  public Class<IsdaCreditCurveParRates> getMarketDataType() {
    return IsdaCreditCurveParRates.class;
  }

  public static IsdaSingleNameCreditCurveParRatesId of(SingleNameReferenceInformation referenceInformation) {
    return new IsdaSingleNameCreditCurveParRatesId(referenceInformation);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code IsdaSingleNameCreditCurveParRatesId}.
   * @return the meta-bean, not null
   */
  public static IsdaSingleNameCreditCurveParRatesId.Meta meta() {
    return IsdaSingleNameCreditCurveParRatesId.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(IsdaSingleNameCreditCurveParRatesId.Meta.INSTANCE);
  }

  private IsdaSingleNameCreditCurveParRatesId(
      SingleNameReferenceInformation referenceInformation) {
    JodaBeanUtils.notNull(referenceInformation, "referenceInformation");
    this.referenceInformation = referenceInformation;
  }

  @Override
  public IsdaSingleNameCreditCurveParRatesId.Meta metaBean() {
    return IsdaSingleNameCreditCurveParRatesId.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the referenceInformation.
   * @return the value of the property, not null
   */
  public SingleNameReferenceInformation getReferenceInformation() {
    return referenceInformation;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      IsdaSingleNameCreditCurveParRatesId other = (IsdaSingleNameCreditCurveParRatesId) obj;
      return JodaBeanUtils.equal(getReferenceInformation(), other.getReferenceInformation());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getReferenceInformation());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(64);
    buf.append("IsdaSingleNameCreditCurveParRatesId{");
    buf.append("referenceInformation").append('=').append(JodaBeanUtils.toString(getReferenceInformation()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code IsdaSingleNameCreditCurveParRatesId}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code referenceInformation} property.
     */
    private final MetaProperty<SingleNameReferenceInformation> referenceInformation = DirectMetaProperty.ofImmutable(
        this, "referenceInformation", IsdaSingleNameCreditCurveParRatesId.class, SingleNameReferenceInformation.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "referenceInformation");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -2117930783:  // referenceInformation
          return referenceInformation;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends IsdaSingleNameCreditCurveParRatesId> builder() {
      return new IsdaSingleNameCreditCurveParRatesId.Builder();
    }

    @Override
    public Class<? extends IsdaSingleNameCreditCurveParRatesId> beanType() {
      return IsdaSingleNameCreditCurveParRatesId.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code referenceInformation} property.
     * @return the meta-property, not null
     */
    public MetaProperty<SingleNameReferenceInformation> referenceInformation() {
      return referenceInformation;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -2117930783:  // referenceInformation
          return ((IsdaSingleNameCreditCurveParRatesId) bean).getReferenceInformation();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code IsdaSingleNameCreditCurveParRatesId}.
   */
  private static final class Builder extends DirectFieldsBeanBuilder<IsdaSingleNameCreditCurveParRatesId> {

    private SingleNameReferenceInformation referenceInformation;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case -2117930783:  // referenceInformation
          return referenceInformation;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case -2117930783:  // referenceInformation
          this.referenceInformation = (SingleNameReferenceInformation) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public IsdaSingleNameCreditCurveParRatesId build() {
      return new IsdaSingleNameCreditCurveParRatesId(
          referenceInformation);
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(64);
      buf.append("IsdaSingleNameCreditCurveParRatesId.Builder{");
      buf.append("referenceInformation").append('=').append(JodaBeanUtils.toString(referenceInformation));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
