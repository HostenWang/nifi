/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.nifi.mongodb;

import org.apache.nifi.controller.AbstractControllerService;
import org.apache.nifi.schema.access.SchemaField;
import org.apache.nifi.schemaregistry.services.SchemaRegistry;
import org.apache.nifi.serialization.SimpleRecordSchema;
import org.apache.nifi.serialization.record.RecordField;
import org.apache.nifi.serialization.record.RecordFieldType;
import org.apache.nifi.serialization.record.RecordSchema;
import org.apache.nifi.serialization.record.SchemaIdentifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StubSchemaRegistry extends AbstractControllerService implements SchemaRegistry {
    @Override
    public RecordSchema retrieveSchema(SchemaIdentifier schemaIdentifier) {
        List<RecordField> fields = new ArrayList<>();
        fields.add(new RecordField("username", RecordFieldType.STRING.getDataType()));
        fields.add(new RecordField("password", RecordFieldType.STRING.getDataType()));
        return new SimpleRecordSchema(fields);
    }

    @Override
    public Set<SchemaField> getSuppliedSchemaFields() {
        return Set.of(SchemaField.SCHEMA_NAME);
    }
}
