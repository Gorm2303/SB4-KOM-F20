/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/OSGi/Activator.java to edit this template
 */
package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.commonenemy.EnemySPI;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 *
 * @author Gorm
 */
public class Activator implements BundleActivator {
    
    @Override
    public void start(BundleContext context) throws Exception {
        //TODO add activation code here
        
        EnemySystem es = new EnemySystem();
        context.registerService(IEntityProcessingService.class, es, null);
        context.registerService(EnemySPI.class, es, null);
    }
    
    @Override
    public void stop(BundleContext context) throws Exception {
        //TODO add deactivation code here
    }
    
}
