/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules.help;

import addon.Addon;
import container.StringFastContainer;
import dbot.Module;
import dbot.ModuleLoader;
import helpers.ParserUtils;
import modules.Help.HelpAddon;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.Event;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IUser;

/**
 *
 * @author bowen
 */
public class Modules implements Addon, HelpAddon {


    @Override
    public String getName() {
        return "Modules";
    }

    @Override
    public String getDescription() {
        return "Displays the module list when called.";
    }

    @Override
    public String getFullHelp() {
        return "**!modules** <page> - *Shows the module list*";
    }
    
    @Override
    public String getShortHelp() {
        return "**!modules** <page> - *Shows the module list*";
    }
    
    @Override
    public int getColour() {
        return 5563639;
    }

    @Override
    public short getUid() {
        return 2;
    }

    @Override
    public boolean hasPermissions(IUser user, IChannel channel, IGuild guild) {
        return true;
    }

    @Override
    public boolean isTrigger(IDiscordClient client, Event e) {
        if (e instanceof MessageReceivedEvent) {
            MessageReceivedEvent em = (MessageReceivedEvent) e;
            String rawString = em.getMessage().getContent();
            String botName = client.getOurUser().getName();
            String commandName = "modules";
            return ParserUtils.startsWithCaseless(rawString, "!" + botName + " " + commandName) || ParserUtils.startsWithCaseless(rawString, "!" + commandName) ;
        }
        return false;
    }

    @Override
    public boolean triggerMessage(IDiscordClient client, MessageReceivedEvent e, ModuleLoader moduleLoader) {
        
        StringFastContainer c = new StringFastContainer(e.getMessage().getContent(), "!");
        if (c.get().equalsIgnoreCase(client.getOurUser().getName())) {
            c.next();
        }
        if (c.get().equalsIgnoreCase("modules")) {
            String finalString = "";
            for (Module module : moduleLoader.getEnabledModules()) {
                finalString += module.getShortName() + " v" + module.getVersion() + " (by " + module.getAuthor() + ") - " + module.getShortDescription()+ "\n";
            }
            e.getChannel().sendMessage("```\n" + finalString + "```");
            return true;
        } else {
            return false;
        }
    }

}
