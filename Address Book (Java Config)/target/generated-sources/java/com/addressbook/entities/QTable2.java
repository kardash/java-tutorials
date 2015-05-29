package com.addressbook.entities;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QTable2 is a Querydsl query type for Table2
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTable2 extends EntityPathBase<Table2> {

    private static final long serialVersionUID = -561760493L;

    public static final QTable2 table2 = new QTable2("table2");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final NumberPath<Integer> column1 = createNumber("column1", Integer.class);

    //inherited
    public final StringPath id = _super.id;

    public QTable2(String variable) {
        super(Table2.class, forVariable(variable));
    }

    public QTable2(Path<? extends Table2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTable2(PathMetadata<?> metadata) {
        super(Table2.class, metadata);
    }

}

