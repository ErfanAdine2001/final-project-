package com.example.erfan_adine_p1_2.service.image;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.Blob;
import java.sql.Clob;

@Service
@RequiredArgsConstructor
public class LobMaker {

    private final SessionFactory sessionFactory;

    public Blob createBlob(InputStream content, long size) {
        return sessionFactory.getCurrentSession().getLobHelper().createBlob(content, size);
    }

    public Clob createClob(InputStream content, long size, Charset charset) {
        return sessionFactory.getCurrentSession().getLobHelper().createClob(new InputStreamReader(content, charset), size);
    }
}

