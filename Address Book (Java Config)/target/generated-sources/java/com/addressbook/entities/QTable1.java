package com.addressbook.entities;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QTable1 is a Querydsl query type for Table1
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTable1 extends EntityPathBase<Table1> {

    private static final long serialVersionUID = -561760494L;

    public static final QTable1 table1 = new QTable1("table1");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final NumberPath<Integer> column1 = createNumber("column1", Integer.class);

    //inherited
    public final StringPath id = _super.id;

    public final SetPath<Table2, QTable2> table2 = this.<Table2, QTable2>createSet("table2", Table2.class, QTable2.class, PathInits.DIRECT2);

    public QTable1(String variable) {
        super(Table1.class, forVariable(variable));
    }

    public QTable1(Path<? extends Table1> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTable1(PathMetadata<?> metadata) {
        super(Table1.class, metadata);
    }

}

