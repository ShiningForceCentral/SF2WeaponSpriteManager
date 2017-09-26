/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sfc.sf2.weaponsprite;

import com.sfc.sf2.graphics.GraphicsManager;
import com.sfc.sf2.graphics.Tile;
import com.sfc.sf2.weaponsprite.io.DisassemblyManager;
import com.sfc.sf2.weaponsprite.io.PngManager;
import com.sfc.sf2.palette.PaletteManager;
import java.awt.Color;

/**
 *
 * @author wiz
 */
public class WeaponSpriteManager {
       
    private PaletteManager paletteManager = new PaletteManager();
    private GraphicsManager graphicsManager = new GraphicsManager();
    private Tile[] tiles;
    private WeaponSprite weaponsprite;

    public Tile[] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[] tiles) {
        this.tiles = tiles;
    }
       
    public void importDisassembly(String palettesPath, String graphicsPath){
        System.out.println("com.sfc.sf2.weaponsprite.WeaponSpriteManager.importDisassembly() - Importing disassembly ...");
        weaponsprite = DisassemblyManager.importDisassembly(palettesPath, graphicsPath);
        tiles = weaponsprite.getTiles();
        graphicsManager.setTiles(tiles);
        System.out.println("com.sfc.sf2.weaponsprite.WeaponSpriteManager.importDisassembly() - Disassembly imported.");
    }
    
    public void exportDisassembly(String graphicsPath){
        System.out.println("com.sfc.sf2.weaponsprite.WeaponSpriteManager.importDisassembly() - Exporting disassembly ...");
        DisassemblyManager.exportDisassembly(weaponsprite, graphicsPath);
        System.out.println("com.sfc.sf2.weaponsprite.WeaponSpriteManager.importDisassembly() - Disassembly exported.");        
    }   
    
    public void importRom(String romFilePath, String paletteOffset, String paletteLength, String graphicsOffset, String graphicsLength){
        System.out.println("com.sfc.sf2.weaponsprite.WeaponSpriteManager.importOriginalRom() - Importing original ROM ...");
        graphicsManager.importRom(romFilePath, paletteOffset, paletteLength, graphicsOffset, graphicsLength,GraphicsManager.COMPRESSION_BASIC);
        tiles = graphicsManager.getTiles();
        System.out.println("com.sfc.sf2.weaponsprite.WeaponSpriteManager.importOriginalRom() - Original ROM imported.");
    }
    
    public void exportRom(String originalRomFilePath, String graphicsOffset){
        System.out.println("com.sfc.sf2.weaponsprite.WeaponSpriteManager.exportOriginalRom() - Exporting original ROM ...");
        graphicsManager.exportRom(originalRomFilePath, graphicsOffset, GraphicsManager.COMPRESSION_BASIC);
        System.out.println("com.sfc.sf2.weaponsprite.WeaponSpriteManager.exportOriginalRom() - Original ROM exported.");        
    }      
    
    public void importPng(String basepath){
        System.out.println("com.sfc.sf2.weaponsprite.WeaponSpriteManager.importPng() - Importing PNG ...");
        weaponsprite = PngManager.importPng(basepath);
        tiles = weaponsprite.getTiles();
        graphicsManager.setTiles(tiles);
        System.out.println("com.sfc.sf2.weaponsprite.WeaponSpriteManager.importPng() - PNG imported.");
    }
    
    public void exportPng(String filepath){
        System.out.println("com.sfc.sf2.weaponsprite.WeaponSpriteManager.exportPng() - Exporting PNG ...");
        PngManager.exportPng(weaponsprite, filepath);
        System.out.println("com.sfc.sf2.weaponsprite.WeaponSpriteManager.exportPng() - PNG exported.");       
    }

    public WeaponSprite getWeaponsprite() {
        return weaponsprite;
    }

    public void setWeaponsprite(WeaponSprite weaponsprite) {
        this.weaponsprite = weaponsprite;
    }
}
