package com.example.demo;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

public class HelloWorld {

    public static void main(String[] args) {
        /*
            定义一个schema字符串, 定义一个名称为hello的查询, 返回的数据类型为string
            这里通过String来定义直接是硬编码, 还能通过SDL文件(后缀为*.graphqls的文件)或编码的方式定义
         */
        String schema = "type Query{hello: String}";

        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema);

        /*
            实例化一个RuntimeWiring, 这个对象关联了一个DataFetcher对象, DataFetcher对象用来获取数据,
            获取方式由开发人员根据实际情况实现, 它只关心返回结果

            这里名称为hello的查询关联了一个简单的StaticDataFetcher对象, 它返回一个字符串world
         */
        RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring().type("Query",
                        builder -> builder.dataFetcher("hello", new StaticDataFetcher("world")))
                .build();

        SchemaGenerator schemaGenerator = new SchemaGenerator();

        // 将schema定义与RuntimeWiring绑定, 产生可执行的schema
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);

        GraphQL build = GraphQL.newGraphQL(graphQLSchema).build();

        // 执行hello查询
        ExecutionResult hello = build.execute("hello");

        // 输出
        System.out.println(hello.getData().toString());


    }
}
