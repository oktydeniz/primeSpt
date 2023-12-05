package com.facility.primeSport.configuration;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class PersistenceNameStrategy extends PhysicalNamingStrategyStandardImpl {

    private static final String TABLE_PREFIX = "psf_";

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        Identifier identifier = super.toPhysicalTableName(name, context);
        return new Identifier(TABLE_PREFIX + identifier.getText(), identifier.isQuoted());
    }
}
