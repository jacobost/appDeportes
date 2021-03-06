package com.svv.localsports;

public class homeItem {
    private int mImageResource;
    private String mTextOrganizador;
    private String mTextCancha;
    private String mTextHora;
    private String mTextNivel;
    private String mTextAsistentes;
    private String mTextComentario;

    public homeItem (int imageResource, String textOrganizador, String textCancha, String textHora, String textNivel, String textAsistentes, String textComentario) {
        mImageResource = imageResource;
        mTextOrganizador = textOrganizador;
        mTextCancha = textCancha;
        mTextHora = textHora;
        mTextNivel = textNivel;
        mTextAsistentes = textAsistentes;
        mTextComentario = textComentario;
    }

    public int getImageResource () {
        return mImageResource;
    }

    public String getTextOrganizador () {
        return mTextOrganizador;
    }

    public String getTextCancha () {
        return mTextCancha;
    }

    public String getTextHora () {
        return mTextHora;
    }

    public String getTextNivel () {
        return mTextNivel;
    }

    public String getTextAsistentes () {
        return mTextAsistentes;
    }

    public String getTextComentario () {
        return mTextComentario;
    }
}
